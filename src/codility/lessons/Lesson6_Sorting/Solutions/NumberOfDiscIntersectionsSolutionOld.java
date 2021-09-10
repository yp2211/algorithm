package codility.lessons.Lesson6_Sorting.Solutions;

import codility.lessons.Lesson6_Sorting.INumberOfDiscIntersections;

/**
 * Created by peng.yang on ${Date}
 */
public class NumberOfDiscIntersectionsSolutionOld implements INumberOfDiscIntersections {
    class Node implements Comparable<Node>{
        public long left;
        public long right;
        public Node(long left, long right){
            this.left = left;
            this.right = right;
        }
        public int compareTo(Node node){
            Long obj1 = new Long(this.right);
            Long obj2 = new Long(node.right);
            return obj1.compareTo(obj2);
        }
    }

    /*
     * N is an integer within the range [0..100,000];
     * each element of array A is an integer within the range [0..2,147,483,647].
     */
    @Override
    public int solution(int[] A) {
        Node[] nodes = new Node[A.length];
        for(int i=0; i<A.length; i++){
            Node node = new Node(i-(long)A[i],i+(long)A[i]);
            nodes[i]=node;
        }
        java.util.Arrays.sort(nodes);
        int count=0;
        for(int i= A.length-1; i>0; i--){
            long left = nodes[i].left;
            int pos = java.util.Arrays.binarySearch(nodes, new Node(0,left));//compare left to right
            if(pos >= 0) {
                while (pos - 1 >= 0) {
                    if (nodes[pos-1].right == left){
                        pos--;
                    }
                    else break;
                }
                count+=(i-pos);
                if(count>10000000) return -1;
            }
            else{
                pos = Math.abs(pos+1);
                count+=(i-pos);
                if(count>10000000) return -1;
            }
        }
        if(count>10000000) return -1;
        return count;

//        int N = A.length;
//        int[] C = new int[N];
//        int r, S = 0, t = 0;
//
//        // Mark left and middle of disks
//        for (int i = 0; i < N; i++) {
//            C[i] = -1;
//            r = A[i];
//            if (r >= i) {
//                C[0]++;
//            } else {
//                C[i - r]++;
//            }
//        }
//        // Sum of left side of disks at location
//        for (int i = 0; i < N; i++) {
//            t += C[i];
//            C[i] = t;
//        }
//        // Count pairs, right side only:
//        // 1. overlaps based on disk size
//        // 2. overlaps based on disks but not centers
//        for (int i = 0; i < N; i++) {
//            r = A[i];
//            S += ((r < N-i) ? r: N-i-1);
//            if (i != N-1) {
//                S += C[((r < N-i) ? i+r: N-1)];
//            }
//            if (S > 10000000) return -1;
//        }
//        return S;

//        int goal = 0;
//        for (int i = 0; i < A.length - 1; i++) {
//            for (int j = i + 1; j < A.length; j++) {
//                int d = j - i;
//                int r1 = A[i];
//                int r2 = A[j];
//                if (d > r1 + r2) {
//                    //外离
//                    continue;
//                } else if (d < Math.abs( r1 - r2)) {
//                    //内含
//                    goal++;
//                } else if (d == r1 + r2) {
//                    // 外切
//                    goal++;
//                } else if (d == Math.abs( r1 - r2)) {
//                    // 内切
//                    goal++;
//                } else if (r1 - r2 < d && d < r1+r2) {
//                    // 相交
//                    goal++;
////                    goal += 2;
//                }
//                if (goal >= 10000000) return -1;
//            }
//        }
//        return goal;
    }
}
