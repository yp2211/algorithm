package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

public class Flags {
    public int solution(int[] A) {
        int flags = 0;
        int N = A.length;
        int K = 1;

        while ((K - 1) * K < N) {
            int flagSetter = K;
            int i = 1;
            while (i < N - 1) {
                if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                    flagSetter -= 1;
                    if (flagSetter == 0) {
                        break;
                    }
                    i += K;
                } else {
                    i +=1;
                }
            }
            if (flagSetter == 0) {
                flags = K;
                K += 1;
            } else {
                break;
            }
        }

        return flags;
    }

    public int solutionHalf(int[] A) {
        int peaks = 0;
        int firstPeak = 0;
        int lastPeak = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {   // flag peaks
                A[i] = Integer.MIN_VALUE;                              // set a special value on peak
                if (peaks == 0) firstPeak = i;          // we will start at first peak when we try to set flags
                else lastPeak = i;                      // and also remember the position of last peak
                peaks++;                                // remember the number of peaks
            }
        }
        if (peaks <= 1) return peaks;                   // if there is only one peak

        int flags = 1;                                  // if there are more than 2 peaks, at least 2 flags can be set
        int distance = lastPeak - firstPeak;            // get the distance between the first and the last peak
        int maxFlags = Math.min((int)Math.sqrt(distance) + 1, peaks);    // it is less than sqrt(distance) that the flags we can set
        int minFlags = 1;                               // half search -> minimum flags
        int K;                                          // half search -> middle point

        while (maxFlags >= minFlags) {
            K = (maxFlags + minFlags) / 2;
            int counter = K;                        // set one flag on the first peak
            int P = firstPeak;                          // start at the first peak
            int Q = P;                              // next peak is after
            while (counter > 0 && Q <= lastPeak) {      // flags are set out, or reached the last peak, finish loop
                if (A[Q] == Integer.MIN_VALUE) {        // if arrived a peak
                    P = Q;                              // remember the position of this peak as previous peak
                    Q = P + K;// move to next peak (The distance between indices P and Q is the absolute value |P − Q|.)
                    counter--;                          // set one flag on this peak
                } else {
                    Q++;                                // if here is not a peak, go to next position
                }
            }
            if (counter == 0) {                         // flag settle was succeed
                flags = K;                              // set result
                minFlags = K + 1;                       // move the minimum pointer to middle
            } else {                                    // flag settle was failed
                maxFlags = K - 1;                       // move the maximum pointer to middle
            }
        }

        return flags;
    }

    public int solution1(int[] A) {
        java.util.ArrayList<Integer> peaks = new java.util.ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }
        if (peaks.size() <= 1) return peaks.size();

        int lastPeak = peaks.get(peaks.size() - 1);

        int flags = 2;
        int tryFlags = flags;
        while (tryFlags * tryFlags <= lastPeak) {
            int prevFlagPosition = peaks.get(0);
            int counter = tryFlags - 1;

            for (int i = 1; i < peaks.size() && counter > 0; i++) {
                int curPosition = peaks.get(i);
                if (prevFlagPosition + tryFlags <= curPosition) {
                    prevFlagPosition = curPosition;
                    counter--;
                }
            }

            if (counter == 0) {
                flags = tryFlags;
                tryFlags++;
            }
        }
        return flags;
    }

    public int solution2(int[] A) {
        int peaks = 0;
        int firstPeak = 0;
        int lastPeak = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {   // flag peaks
                A[i] = -1;                              // set a special value on peak
                if (peaks == 0) firstPeak = i;          // we will start at first peak when we try to set flags
                else lastPeak = i;                      // and also remember the position of last peak
                peaks++;                                // remember the number of peaks
            }
        }
        if (peaks <= 1) return peaks;                   // if there is only one peak

        int flags = 2;

        int distance = lastPeak - firstPeak;            // get the distance between the first and the last peak
        int maxFlags = (int)Math.sqrt(distance) + 1;    // it is less than sqrt(distance) that the flags we can set
        for (int K = 2; K <= maxFlags; K++) {
            if (check(K, A)) {
                flags = K;
            } else break;
        }

        return flags;
    }

    private boolean check(int K, int[] A) {
        int flags = K;
        int P = 0;
        while (P < A.length && flags > 0) {
            if (A[P] < 0) {
                flags -= 1;
                P += K;
            } else {
                P += 1;
            }
        }
        return flags == 0;
    }
}
