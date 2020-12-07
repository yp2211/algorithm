package codility.lessons.Lesson5_PrefixSums;

/**
 * Created by peng.yang on ${Date}
 */
public class CountDivSolution extends AbstractCountDiv {
    @Override
    public int solution(int A, int B, int K) {
//        int goal = 0;
////        int minNK = K * (int)(Math.ceil(A / (double)K));
////        int maxNK = K * (int)(Math.floor(B / (double)K));
//
////        goal = (maxNK - minNK) / K + 1;
//        if (A == B) {
////            return (A % K == 0) ? 1 : 0;
//            goal = goal = (int)(Math.floor(B / (double)K)) - (int)(Math.ceil(A / (double)K)) + 1;
//        } else {
//            goal = (int)(Math.floor(B / (double)K)) - (int)(Math.ceil(A / (double)K)) + 1;
//        }
//
//        return goal;
        return (int)(Math.floor(B / (double)K)) - (int)(Math.ceil(A / (double)K)) + 1;
    }
}
