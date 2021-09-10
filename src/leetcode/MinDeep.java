package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDeep {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(minDeepDeetFirst(node1));
        System.out.println(minDeepWideFirst(node1));

    }

    private static int minDeepDeetFirst(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDeepDeetFirst(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDeepDeetFirst(root.right), min);
        }

        return min + 1;
    }

    private static int minDeepWideFirst(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        root.deep = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left == null && treeNode.right == null) {
                return treeNode.deep;
            } else if (treeNode.left != null) {
                treeNode.left.deep = treeNode.deep + 1;
                queue.offer(treeNode.left);
            } else {
                treeNode.right.deep = treeNode.deep + 1;
                queue.offer(treeNode.right);
            }
        }

        return 0;
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public int deep;
        public TreeNode(int val) {this.val = val;}
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
