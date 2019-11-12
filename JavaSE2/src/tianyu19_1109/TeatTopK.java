package tianyu19_1109;

public class TeatTopK {
}
    public static void main(String args[]) {
        int num = 97;
        int ret = isPrime(num);
        if (ret == 1) {
            System.out.println("prime");
        } else {
            System.out.println("not prime")
        }
        return 0;
    }

    public static int isPrime(int num) {
        if (num == 1）｛
        return 0;
	｝ else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0） ｛
                return 0；
			｝
		｝
                return 1;
            }
             */
            class Solution {
                public List<Integer> postorderTraversal(TreeNode root) {
                    if (root == null) {
                        return null;
                    }
                    Stsck<treeNode> stack = new Stack<>();
                    TreeNode cur = root;
                    TreeNode prev = null;//指向上一次访问的节点
                    while (cur != null) {
                        stack.push(cur);
                        cur = cur.left;
                    }
                    TreeNode top = stack.peek();
                    if (top.right == null || prev == top.right) {
                        System.out.println("")
                        stack.pop;
                    }
                }
            }