package codility.lessons.Lesson6_Sorting;

/**
 * Created by peng.yang on ${Date}
 */
public class DistinctSolution extends AbstractDistinct {

    @Override
    public int solution(int[] A) {
        java.util.HashMap hm = new java.util.HashMap();
        for (int i = 0; i < A.length; i++) {
            hm.put(A[i], true);
        }
        return hm.size();


//        int goal = 0;
//        int[] B = new int[2000001];
//        for (int a : A) {
//            B[1000000 + a]++;
//        }
//
//        for (int b : B) {
//            if (b > 0) goal++;
//        }
//
//        return goal;
    }
}
