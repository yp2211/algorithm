package codility.exams.rakuten.Solutions;


import codility.exams.rakuten.IBiratian;

/**
 * Created by peng.yang on ${Date}
 */
public class Biratian implements codility.exams.rakuten.IBiratian {

    public int solution(int[] A) {
        int goal = 0;
        int binarianA = binarian(A);

        while (binarianA > 0) {
            // point: Bitwise operation
            // Example: 1010111 -> 1000000 -> 2^6 -> i=6 -> B{...,6}
            int Bi = (Integer.toBinaryString(binarianA)).length() - 1;
            binarianA -= pow2(Bi);
            goal++;
        }

        return goal;
    }

    /*
        O(N)
     */
    private static int binarian(int[] X) {
        int binarian = 0;
        for (int aX : X) {
            binarian += pow2(aX);
        }
        return binarian;
    }

    /*
        point: Transfer code for computing pow2
     */
    private static int pow2(int Xi) {
        return 1 << Xi;
    }


    /*
        ver.examination
     */
    public static int solutionGetB(int[] A) {
        int goal = 0;
        int binarianA = binarian(A);

        //由于题中没有要求求解B数组，无需开辟B数组的空间，徒增空间复杂度
//        ArrayList<Integer> B  = new ArrayList<Integer>();                       // code for printing B
        while (binarianA > 0) {

            // point: Bitwise operation
            // 保留首位的1，即可得到小于binarian的2^i
            // 例： 1010111 -> 1000000 -> 2^6 -> i=6 -> B{...,6}
            // 1010111
            /////////////////////////////////////////////////////////////////////////
            String strleft = Integer.toBinaryString(binarianA);

            //1000000
            //String -> char[]
            char[] charsBinarianTemp = strleft.toCharArray();
            //1010111 -> 1000000
            for (int i = 1; i < charsBinarianTemp.length; i++) {
                charsBinarianTemp[i] = '0';
            }

            //2^6 -> i=6
            // char[] -> String
            String strBinarianTemp = new String(charsBinarianTemp);
            // String -> int
            int binarianTemp = Integer.parseInt(strBinarianTemp, 2);
            /////////////////////////////////////////////////////////////////////////
//            int Bi = (Integer.toBinaryString(left)).length() - 1;
            /////////////////////////////////////////////////////////////////////////

            binarianA = binarianA - binarianTemp;
            goal = goal + 1;

            // B{...,6}
            //由于题中没有要求求解B数组，无需开辟B数组的空间，徒增空间复杂度
//            B.add(strBinarianTemp.length() - 1);                                // code for printing B
        }

//        // code for printing B start
//        Object[] a= B.toArray();
//        System.out.print("B: {");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]);
//            if (i < a.length -1) System.out.print(",");
//        }
//        System.out.println("}");
//        // code for printing B end

        return goal;
    }




}
