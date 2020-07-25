package test_2020_0725;

public class HasSubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        // 1.先确定两棵树要比较的起始位置
        if (root1 == null || root2 == null) {
            return false; // 空树不属于任何树的子树
        }
        boolean result = false;
        // 先比较根节点是否相同
        if (root1.val == root2.val) {// 找到起始位置
            // 判断从起始位置开始两棵树是否相同
            result = IsSameFromBegin(root1, root2);
        }
        // 根节点不相同，再依次递归找左右子树的起始位置
        if (result == false) {
            result = HasSubtree(root1.left, root2);
        }
        if (result == false) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    // 比较从起始位置开始，两棵树是否相同
    public boolean IsSameFromBegin(TreeNode begin, TreeNode beginSub) {
        if (beginSub == null) {
            return true;
        }
        if (begin == null) {
            return false;
        }
        if (beginSub.val != begin.val) {
            return false;
        }
        // 递归比较左右子树
        return IsSameFromBegin(begin.left, beginSub.left)
                && IsSameFromBegin(begin.right, beginSub.right);
    }
}
