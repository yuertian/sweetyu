package tianyu19_1004;

import java.util.*;

public class BinaryTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    //先序遍历
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

    //层序遍历  通过队列实现
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //创建一个队列辅助进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        //让根节点入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            //循环取出对首元素，并访问
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            //将当前队首元素的左右子树分别入队列
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //判断一棵树是不是完全二叉树
    public boolean isCompeleTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 1. 先对树进行层序遍历
        // 如果这个标记为 false, 说明还是处在第一阶段
        // 如果这个标记为 true , 接下来的节点就不能有子树
        // 也就是第二阶段开始了
        boolean needNoChild = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 对这个元素的情况进行判定了.
            // 访问是一组比较复杂的判断
            if (!needNoChild) {
                // 第一阶段的情况
                if (cur.left != null && cur.right != null) {
                    // 合格的状态, 继续往下遍历.
                    // 就把左右子树加入队列就行了
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    // 这种情况铁定不是完全二叉树
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    // 这是临界状态, 开启第二阶段
                    queue.offer(cur.left);
                    needNoChild = true;
                } else {
                    // 左右子树都为空, 开启第二阶段
                    needNoChild = true;
                }
            } else {
                // 第二阶段的情况
                // 第二阶段要求节点必须没有子树. 只要子树存在, 就不是完全二叉树
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }  // end if
        }  // end while
        return true;
    }



    //非递归实现先序遍历
    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
    }

//    //非递归实现中序遍历
//    public void inOrder(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = stack.push(root);
//        if (root == null) {
//            return;
//        }
//        while (true) {
//            while (cur != null) {
//                stack.push(cur.left);
//                cur = cur.left;
//            }
//            if (!stack.isEmpty()) {
//                break;
//            }
//            TreeNode top = stack.pop();
//        }
//        return;
//    }

    //层序遍历

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
    //借助遍历的方式，访问节点的时候，先判断是不是叶子节点，如果是就 ++
    public static int leafSize = 0;
    public static int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
        return leafSize;
    }


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

//求二叉树的最大深度
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

//判断是不是平衡二叉树 
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

//对称二叉树
public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }


    static int index = 0;
    public static TreeNode buildTree(String line) {
        index = 0;
        return createTreePreOrder(line);
    }

    //辅助完成递归
    //通过先序遍历构建二叉树
    public static TreeNode createTreePreOrder(String line) {
        char c = line.charAt(index);
        if (c == '#') {
            return null;
        }
        TreeNode root = new TreeNode(c);
        index++;
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }
    //中序遍历并输出
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
       // inOrder(root.right);
    }

//    public static void main(String[] Args) {
////        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String line = scanner.next();
//            //line 就是一组现需遍历的结果（带 #）
//            TreeNode root = buildTree(line);
//            inOrder(root);
//            System.out.println();
//        }
//    }
}
