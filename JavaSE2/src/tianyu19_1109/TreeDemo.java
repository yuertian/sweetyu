package tianyu19_1109;

import java.util.ArrayList;
import java.util.List;

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
        helper(root, 0);
        return result;
    }

    //辅助完成递归遍历的过程
    private void helper(TreeNode root, int level) {
        if (level == result.size) {
          //达到的第level层还没有对应的数组
            // 此时就需要创建一个新的数组加到result中
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    private TreeNode lca = null;//保存最终的公共祖先节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.借助一个辅助函数，在root中查找p和q, 招待返回1，没找到返回0
        //2.递归左子树查找，递归柚子树查找，在对比根节点
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
        int left = findNode(root, p ,q) ? 1 : 0;
        //递归查找右子树
        int right = findNode(root, p, q) ? 1 : 0;
        //对比当前节点是否找到
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            //找到lca,就是当前的root
            lca = root;
        }
        return left + right +mid > 0;
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
        //3.如果左侧链表的头结点不为null,当前链表的尾巴找到，让尾节点和root互指
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        //循环结束后，leftTail 就指向了左侧链表的最后一个节点。
        //要时刻注意，left 有可能是null
        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = pRootOfTree;
        }
        return left == null ? pRootOfTree : left;
    }


}


