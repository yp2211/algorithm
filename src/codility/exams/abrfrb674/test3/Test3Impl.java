package codility.exams.abrfrb674.test3;

import java.util.ArrayList;

public class Test3Impl implements ITest3 {
    @Override
    public int solution(int N, String S) {
        final String SPLIT_TAG = " ";
        final String ROW_SEATS = "ABCDEFGHJK";
        // 1A 2F 1C

        //ArrayList<String> rows = new ArrayList<>();
        String[] rows = new String[N];
        if (!"".equals(S)) {
            String[] reservedSeats = S.split(SPLIT_TAG);
            for (String reservedSeat : reservedSeats) {
                String row = reservedSeat.substring(0, reservedSeat.length() - 1);
                String seat = reservedSeat.substring(reservedSeat.length() - 1);
                int rowNo = Integer.parseInt(row) - 1;

                if (rows[rowNo] == null) {
                    rows[rowNo] = ROW_SEATS;
                }

                rows[rowNo] = rows[rowNo].replaceFirst(seat, "X");
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            // BCDEFGHJ
            if (rows[i] == null || rows[i].indexOf("BCDEFGHJ") >= 0) {
                result += 2;
            } else if (rows[i].indexOf("BCDE") >= 0
                    || rows[i].indexOf("FGHJ") >= 0
                    || rows[i].indexOf("DEFG") >= 0) {
                result += 1;
            }
        }

        return result;
    }
}
