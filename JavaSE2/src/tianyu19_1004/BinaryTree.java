package tianyu19_1004;

import tianyu19_1109.TreeDemo;

public class BinaryTree {
    static class TreeNode {
        public int val;
        public TreeDemo.TreeNode left;
        public TreeDemo.TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSubTree(s,t);
        }

    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + (left > right ? left : right);
    }

    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}
