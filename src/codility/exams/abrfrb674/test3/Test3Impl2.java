package codility.exams.abrfrb674.test3;

public class Test3Impl2 implements ITest3 {
    /*
     * N: [1...50]
     * S: 1A 2F 1C
     */
    @Override
    public int solution(int N, String S) {
        final String SPLIT_TAG = " ";
        final String ROW_SEATS = "ABC DEFG HJK";

        // initialize rows
        String[] rows = new String[N];
        for (int i = 0; i < N; i++) {
            rows[i] = ROW_SEATS;
        }

        // set reserved seats
        if (!"".equals(S)) {
            String[] reservedSeats = S.split(SPLIT_TAG);
            for (String reservedSeat : reservedSeats) {
                char seat = reservedSeat.charAt(reservedSeat.length() - 1);
                int rowNo = Integer.parseInt(reservedSeat.substring(0, reservedSeat.length() - 1)) - 1;
                rows[rowNo] = rows[rowNo].replace(seat, 'X');
            }
        }

        // main process
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += solution1(rows[i]);
//            result += solution2(rows[i]);
        }

        return result;
    }

    int solution2(String seatsInRow) {
        int result = 0;
        final int TICKETS_NUMB = 4;
        final char ROAD_TAG = ' ';
        int counter = 0;
        for (char seat : seatsInRow.toCharArray()) {
            switch (seat) {
                case 'X':
                    counter = 0;
                    break;
                case ROAD_TAG:
                    counter = counter >= 2 ? 2 : 0;
                    break;
                default:
                    counter++;
                    break;
            }
            if (counter == TICKETS_NUMB) {
                result++;
                counter = 0;
            }
        }
        return result;
    }


    int solution1(String seatsInRow) {
        int result = 0;

        if (seatsInRow == null || seatsInRow.indexOf("BC DEFG HJ") >= 0) {
            result += 2;
        } else if (seatsInRow.indexOf("BC DE") >= 0
                || seatsInRow.indexOf("FG HJ") >= 0
                || seatsInRow.indexOf("DEFG") >= 0) {
            result += 1;
        }
        return result;
    }
}
