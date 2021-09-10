package leetcode;

public class Rob {
    public static void main(String[] args) {
        /*
//        int[] A = new int[]{2,7,9,3,1};
        int[] A = new int[]{2,1,3};
//        int[] A = new int[]{2};
        // line
//        System.out.println(maxMoney(A, A.length - 1));
        System.out.println(maxMoney(A));

        // circle
        System.out.println(Math.max(maxMoneyCircle(A, 0, A.length-2),
                maxMoneyCircle(A, 1, A.length-1)));
*/
        TreeNode node5 = new TreeNode(1, null, null);
        TreeNode node4 = new TreeNode(3, null, null);
        TreeNode node3 = new TreeNode(3, null, node5);
        TreeNode node2 = new TreeNode(2, null, node4);
        TreeNode node1 = new TreeNode(3, node2, node3);

        int[] bestResult = dfs(node1);
        System.out.println(Math.max(bestResult[0], bestResult[1]));
    }

    static int maxMoney(int[] A, int index) {
        int money = 0;

        if (A == null || index < 0) {
            return money;
        }
        if (index == 0) {
            return A[0];
        }
        return Math.max(maxMoney(A, index - 1),
                maxMoney(A, index - 2) + A[index]);
    }

    static int maxMoney(int[] A) {
        int money = 0;
        int length = A.length;

        if (A == null || length < 0) {
            return money;
        }
        if (length == 1) {
            return A[0];
        }
        /*
        int[] dp = new int[length];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + A[i]);
        }
        return dp[length-1];
        */

        int first = A[0], second = A[1];
        for(int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first+A[i], second);
            first = temp;
        }
        return second;
    }

    static int maxMoneyCircle(int[] A, int start, int end) {
        int money = 0;

        if (A == null || end < 0) {
            return money;
        }
        if (end == 0) {
            return A[0];
        }

        int first = A[start], second = Math.max(A[start], A[start+1]);
        for(int i = start+2; i <= end; i++) {
            int temp = second;
            second = Math.max(first+A[i], second);
            first = temp;
        }
        return second;
    }

    static int maxMoneyTree(int[] A, int root) {
        int money = 0;

        if (A == null || root < 0) {
            return money;
        }
        if (root == 0) {
            return A[0];
        }

        return money;
    }

    static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // selected best result, not selected best result
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);

        return new int[]{selected, notSelected};
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public int deep;
    public TreeNode() {}
    public TreeNode(int val) {this.val = val;}
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
