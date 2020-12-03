package codility.challenges;

/*

    MaximumCanMix.md
 */
public class MaximumCanMix {
    // kinds of juice
    // juice.length == N [2..100,000]

    // capacity of juice
    // juice[J]

    // count of glasses
    // capacity.length == N [2..100,000]

    // capacity of glass[J]
    // capacity[J] == [1..1,000,000,000]

    // for each J juice[J] ≤ capacity[J]

    //        int MaxCapacity = 1000000000;
    //        int MaxN = 100000;

    // https://app.codility.com/cert/view/certBAHYYY-799W2CKH32G9GM4U/
    // https://app.codility.com/cert/view/certBAHYYY-799W2CKH32G9GM4U/details/
    public static int solution(int[] juice, int[] capacity) {

        int target = 1;

        // 1. sort
        int current;
        int currentCapacity;
        for (int i = 0; i < juice.length - 1; i++) {
            current = juice[i + 1];
            currentCapacity = capacity[i + 1];

            int preIndex = i;
            while (preIndex >= 0 && current < juice[preIndex]) {
                juice[preIndex + 1] = juice[preIndex];
                capacity[preIndex + 1] = capacity[preIndex];
                preIndex--;
            }
            juice[preIndex + 1] = current;
            capacity[preIndex + 1] = currentCapacity;
        }
//        System.out.println(java.util.Arrays.toString(juice));
//        System.out.println(java.util.Arrays.toString(capacity));

        // 2. mix
        int tempCount = 1;
        for (int j = 0; j < juice.length; j++) {
            int left = capacity[j] - juice[j];

            if (left <= 0) continue;
            tempCount = 1;
            for (int k = 0; k < juice.length; k++) {
                if (k == j) continue;

                if (left >= juice[k]) {
                    tempCount += 1;
                    left = left - juice[k];

                    if (left <= 0) {
                        break;
                    }
                }
            }

            if (tempCount > target) {
                target = tempCount;
            }

        }

        return target;
    }

    public static int invoke5(int[] juice, int[] capacity) {

        int target = 1;

        // 1. sort
        int current;
        int currentCapacity;
//        //left
//        int maxLeft = 0;
//        int[] left = new int[juice.length];

        int currentLeft;
        for (int i = 0; i < juice.length - 1; i++) {
            current = juice[i + 1];
            currentCapacity = capacity[i + 1];
//            //left
//            currentLeft = currentCapacity - current;
//            left[i + 1] = currentLeft;

            int preIndex = i;
            while (preIndex >= 0 && current < juice[preIndex]) {
                juice[preIndex + 1] = juice[preIndex];
                capacity[preIndex + 1] = capacity[preIndex];
                preIndex--;
            }
            juice[preIndex + 1] = current;
            capacity[preIndex + 1] = currentCapacity;
        }

//        System.out.println(java.util.Arrays.toString(juice));
//        System.out.println(java.util.Arrays.toString(capacity));

        // 2. mix
        int tempCount;
        for (int j = 0; j < juice.length; j++) {
            int left = capacity[j] - juice[j];

            if (left <= 0) continue;
            tempCount = 1;
            for (int k = 0; k < juice.length; k++) {
                if (k == j) continue;

                if (left >= juice[k]) {
                    tempCount += 1;
                    left = left - juice[k];

                    if (left <= 0) {
                        break;
                    }
                }
            }

            if (tempCount > target) {
                target = tempCount;
            }

        }

        return target;
    }

    public static int invoke1(int[] juice, int[] capacity) {

        int MaxCapacity = 0;
        int target;

        // 1. get capacity left for every glass : left[]
        // 1. get max capacity left of all glasses : MaxCapacityLeft, MaxCapacityLeftJuiceIndex
        int[] left = new int[juice.length];

        int MaxCapacityLeft = 0;
        int MaxCapacityLeftJuiceIndex = 0;
        for (int i = 0; i < juice.length; i++) {
            if (capacity[i] > MaxCapacity) {
                MaxCapacity = capacity[i];
            }

            left[i] = capacity[i] - juice[i];
            if (left[i] > MaxCapacityLeft) {
                MaxCapacityLeft = left[i];

                if (juice[i] > juice[MaxCapacityLeftJuiceIndex]) {
                    MaxCapacityLeftJuiceIndex = i;
                }
            }
        }

        // 2. get sorted juice
        java.util.Arrays.sort(juice);

        // 3. mix
        target = 1;
        for (int k = 0; k < juice.length; k++) {
            if (k == MaxCapacityLeftJuiceIndex) continue;

            int juiceCapacity = juice[k];

            if (MaxCapacityLeft >= juiceCapacity) {
                MaxCapacityLeft = MaxCapacityLeft - juiceCapacity;
                target++;
            } else {
                break;
            }
        }

        return target;
    }

    public static int  invoke2(int[] juice, int[] capacity) {

        int MaxCapacity = 0;
        int target = 0;

        // 1. get capacity left for every glass : left[]
        // 1. get max capacity left of all glasses : MaxCapacityLeft, MaxCapacityLeftJuiceIndex
        int[] left = new int[juice.length];

        int MaxCapacityLeft = 0;
        int MaxCapacityLeftJuiceIndex = 0;
        for (int i = 0; i < juice.length; i++) {
            if (capacity[i] > MaxCapacity) {
                MaxCapacity = capacity[i];
            }

            left[i] = capacity[i] - juice[i];
            if (left[i] > MaxCapacityLeft) {
                MaxCapacityLeft = left[i];

                if (juice[i] > juice[MaxCapacityLeftJuiceIndex]) {
                    MaxCapacityLeftJuiceIndex = i;
                }
            }
        }

        // 2.
//        int sortedJuiceLength = (int)Math.floor(MaxCapacity/10);
        int[] sortedJuice = new int[MaxCapacity + 1];
        // 2147483647
        // 1000000000
        // j: [2..100,000]
        for (int indexX : juice) {
            //            int indexY = (int)Math.ceil(juice[j]/10);
            sortedJuice[indexX] = sortedJuice[indexX] <= 0 ? 1 : sortedJuice[indexX] + 1;
        }

        // 3.MaxCapacityLeft = MaxCapacityLeft;
        target = 1;
        boolean outOfCapacity = false;
        for (int k = 0; k < sortedJuice.length; k++) {
            // k : capacity
            // sortedJuice[k] : glasses(kinds) of the juices which has capacity k.
            if (sortedJuice[k] > 0) {
                for (int x = 0; x < sortedJuice[k]; x++) {
                    if (MaxCapacityLeft >= k) {
                        MaxCapacityLeft = MaxCapacityLeft - k;
                        target++;
                    } else {
                        outOfCapacity = true;
                        break;
                    }
                }
            }
            if (outOfCapacity) {
                break;
            }

        }

        return target;
    }

    public static int  invoke(int[] juice, int[] capacity) {
        int MaxCapacity = 0;
        int target = 0;

        // 1. get capacity left for every glass : left[]
        // 1. get max capacity left of all glasses : MaxCapacityLeft, MaxCapacityLeftJuiceIndex
        int[] left = new int[juice.length];

        int MaxCapacityLeft = 0;
        int MaxCapacityLeftJuiceIndex = 0;
        for (int i = 0; i < juice.length; i++) {
            if (capacity[i] > MaxCapacity) {
                MaxCapacity = capacity[i];
            }

            left[i] = capacity[i] - juice[i];
            if (left[i] > MaxCapacityLeft) {
                MaxCapacityLeft = left[i];

                if (juice[i] > juice[MaxCapacityLeftJuiceIndex]) {
                    MaxCapacityLeftJuiceIndex = i;
                }
            }
        }

        // 2.
        int sortedJuiceLength = (int)Math.floor(MaxCapacity/10);
        int[][] sortedJuice = new int[sortedJuiceLength][10];
        // 2147483647
        // 1000000000
        // j: [2..100,000]
        for (int indexX : juice) {
            int indexY = (int) Math.ceil(indexX / 10);
            sortedJuice[indexX][indexY] = sortedJuice[indexX][indexY] <= 0 ? 1 : sortedJuice[indexX][indexY] + 1;
        }

        // 3.MaxCapacityLeft = MaxCapacityLeft;
        target = 1;
        boolean outOfCapacity = false;
        for (int k = 0; k < sortedJuice.length; k++) {
            for (int l = 0; l < 10; l++) {
                // k : capacity
                // sortedJuice[k] : glasses(kinds) of the juices which has capacity k.
                if (sortedJuice[k][l] >= 0) {
                    for (int x = 0; x < sortedJuice[k][l]; x++) {
                        if (MaxCapacityLeft >= k) {
                            MaxCapacityLeft = MaxCapacityLeft - k;
                            target++;
                        } else {
                            outOfCapacity = true;
                            break;
                        }
                    }
                }
                if (outOfCapacity) {
                    break;
                }
            }
            if (outOfCapacity) {
                break;
            }
        }

        return target;
    }

    public static class Glass{
        private int _juiceIndex;
        private int _juiceCapacity;
        private int _glassCapacity;

        public Glass(int juiceIndex, int juiceCapacity, int glassCapacity) {
            this._juiceIndex = juiceIndex;
            this._juiceCapacity = juiceCapacity;
            this._glassCapacity = glassCapacity;
        }

        public int get_juiceIndex() {
            return _juiceIndex;
        }

        public void set_juiceIndex(int _juiceIndex) {
            this._juiceIndex = _juiceIndex;
        }

        public int get_juiceCapacity() {
            return _juiceCapacity;
        }

        public void set_juiceCapacity(int _juiceCapacity) {
            this._juiceCapacity = _juiceCapacity;
        }

        public int get_glassCapacity() {
            return _glassCapacity;
        }

        public void set_glassCapacity(int _glassCapacity) {
            this._glassCapacity = _glassCapacity;
        }
    }

}
