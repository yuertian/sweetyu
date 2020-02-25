package tianyu19_1109;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeDemo {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }





    private List<List<Integer>> result = new ArrayList<>();
    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root,0);
        return result;
    }

    //辅助完成递归遍历的过程
   private void helper(TreeNode root, int level) {
       if (level == result.size()) {
           result.add(new ArrayList<>());
       }
       result.get(level).add(root.val);
   }

    private TreeNode lca = null;//保存最终的公共祖先节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.借助一个辅助函数，在root中查找p和q, 找到返回1，没找到返回0
        //2.递归左子树查找，递归右子树查找，再对比根节点
        //3.如果这三个位置，有两个找到了，这个当前节点就是要找到的最近公共祖先
        if (root == null) {
            return null;
        }
        //辅助函数
        findNode(root, p, q);
        return lca;
    }

    //辅助函数
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        //递归查找左子树
        int left = findNode(root, p, q) ? 1 : 0;
        //递归查找右子树
        int right = findNode(root, p, q) ? 1 : 0;
        //对比当前节点是否找到
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            //找到lca,就是当前的root
            lca = root;
        }
        return left + right + mid > 0;
    }

    //二叉树搜索树转换成排序双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        //使用中序遍历，就能够的到有效序列
        //把相邻元素互相指向，left指向前一个元素，right指向后一个元素
        //判断特殊情况，如果是空树，或者只有一个节点
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        //2.递归把左子树变成双向链表，并返回这个链表的第一个节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        //3.如果左侧链表的头结点不为null,当前链表的尾巴找到，让尾节点和root互指
        while (left != null && left.right != null) {
            leftTail = left.right;
        }
        //循环结束后，leftTail 就指向了左侧链表的最后一个节点。
        //要时刻注意，left 有可能是null
        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        //把右侧链表的头结点和当前节点相互指向
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        //返回整个链表的头结点
        return left == null ? pRootOfTree : left;
    }

    //根据先序遍历与中序遍历构建二叉树
    private int index = 0;
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        index = 0;
        return buildTreeHelper(preOrder, inOrder, 0, inOrder.length);
    }
                                     //先序遍历的结果   //中序遍历的结果
    private TreeNode buildTreeHelper(int[] preOrder,int[] inOrder,
                                     int inOrderLeft, int inOrderRight) {
        //先判定非法情况
        if (inOrderLeft >= inOrderRight) {
            //这个子树的中序遍历是没有的，这就是个空子树
            return null;
        }
        if (index >= preOrder.length) {
            return null;
        }
        //取出当前值构造当前子树的根节点
        TreeNode root = new TreeNode(preOrder[index]);
        index++;//取完这个节点就可以取下一个节点了
        //需要找到这个节点在中序遍历中的位置
        //只要 先序遍历 和 中序遍历 序列都是对的，pos就一定能够找到
        int pos = find(inOrder, inOrderLeft, inOrderRight, root.val);
        root.left = buildTreeHelper(preOrder, inOrder, inOrderLeft, pos);
        root.right = buildTreeHelper(preOrder, inOrder, pos + 1, inOrderRight);
        return root;
    }

    //辅助函数
    private int find(int[] inOrder, int inOrderLeft, int inOrderRight, int val) {
        for (int i = inOrderLeft; i < inOrderRight; i++) {
            if (inOrder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}




