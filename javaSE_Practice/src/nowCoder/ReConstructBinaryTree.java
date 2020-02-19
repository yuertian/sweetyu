//package nowCoder;
//
//import javax.swing.tree.TreeNode;
//
///**
// * Definition for binary tree
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
//public class ReConstructBinaryTree {
//    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
//        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1,
//                in, 0, in.length - 1);
//        return root;
//    }
//
//    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre,
//                                           int[] in, int startIn, int endIn){
//        if (startPre > endPre || startIn > endIn) {
//            return null;
//        }
//        //创建一个根节点，目前还没有子树，也就是说只有一个根节点
//        TreeNode root = new TreeNode(pre[startPre]);
//        for (int i = startIn; i <= endIn; i++) {
//            //如果只有一个根节点
//            if (in[i] == pre[startPre]) {
//                //通过先序遍历和中序遍历的情况来递归创建当前根节点的左子树和右子树
//                //创建左子树
//                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn,
//                        in, startIn, i - 1);
//                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre,
//                        in, i + 1, endIn);
//                break;
//            }
//        }//循环结束，所有节点的子树都创建完毕
//        return root;
//    }
//}
