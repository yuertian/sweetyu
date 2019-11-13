package tianyu19_1004;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result  = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //先访问当前根节点
        result.add(root.val);
        //递归访问左子树
        result.addAll(preOrderTraversal(root.left));
        //递归访问右子树
        result.addAll(preOrderTraversal(root.right));
        return result;
    }

    //中序遍历
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //递归遍历左子树
        result.addAll(inOrderTraversal(root.left));
        //访问根节点
        result.add(root.val);
        //递归遍历右子树
        result.addAll(inOrderTraversal(root.right));
        return result;
    }

    //后续遍历
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //递归遍历左子树
        result.addAll(postOrderTraversal(root.left));
        //递归遍历右子树
        result.addAll(postOrderTraversal(root.right));
        //访问根节点
        result.add(root.val);
        return result;
    }

    //递归遍历 求节点个数
    public int getSize1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //  1 + 左子树的节点个数 + 右子树的节点个数
        return 1 + getSize1(root.left) + getSize1(root.right);
    }

    public static int treeSize = 0;
    //子问题思路求节点个数
    public void getSize2(TreeNode root) {
        if (root == null) {
            return;
        }
        treeSize++;
        getSize2(root.left);
        getSize2(root.right);
    }

    //求叶子节点




    //判断两个树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 本质上还是借助递归的思想拆分问题.
        // 判定两个树相同 => 比较根节点是否相同 + 比较左子树是否相同 + 比较右子树是否相同
        // 1. 如果两棵树都是空树, 这种直接返回 true
        if (p == null && q == null) {
            return true;
        }
        // 2. 如果两棵树一个为空一个不为空, 直接返回 false
        if (p == null || q == null) {
            return false;
        }
        // 3. 如果都不为空树
        //  a) 比较一下根节点的值是否相同. 如果不相同, 就直接返回 false
        if (p.val != q.val) {
            return false;
        }
        //  b) 递归比较左子树和递归比较右子树看看是不是也相同.
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    //判断一棵树是不是另一棵的子树
    public boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSameTree(s,t);
        }
        if (!ret) {
            ret = isSubTree(s.left, t);
        }
        if (!ret) {
            ret = isSubTree(s.right, t);
        }
        return ret;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
