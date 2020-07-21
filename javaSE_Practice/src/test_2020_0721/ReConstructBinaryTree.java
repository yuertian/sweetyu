package test_2020_0721;


import javax.swing.tree.TreeNode;



 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        return reConstructBinaryTreeHelper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    public TreeNode reConstructBinaryTreeHelper(int [] pre, int preStart, int preEnd,
                                                int [] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]); // 根节点是先序数组的第一个节点
        int i = inStart;
        for (; i <= inEnd; i++) { // 在中序数组中找到根节点
            if (in[i] == pre[preStart]) {
                // 先序的第一个节点，是根节点，将中序分为前后两部分
                // 根据中序，可以确定左子树节点个数为 i-inStart(不一定是从0开始)
                // 所以在pre序列中，从 preStart+1 到 i-inStart 为左子树的先序序列
                root.left = reConstructBinaryTreeHelper(
                        pre, preStart + 1, preStart + i-inStart, in, inStart, i - 1);
                // 从 preStart+1 + i-inStart 到 preEnd 为右子树的先序序列
                root.right = reConstructBinaryTreeHelper(
                        pre, preStart + i-inStart + 1, preEnd, in, i + 1, inEnd);
                // 建立完毕，退出
                break;
            }
        }
        return root;
    }
}