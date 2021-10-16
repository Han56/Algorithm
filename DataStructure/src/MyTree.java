import sun.reflect.generics.tree.Tree;

import java.sql.Array;
import java.util.*;

/**
 * @author han56
 * @description 数据结构 二叉树系列问题
 * @create 2021/9/21 下午7:41
 */
public class MyTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){
        }
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
    * 创造一颗新的二叉树 for test
    *            5
    *         /    \
    *        4      6
    *      /  \    / \
    *    1     2  7   8
    * */
//    public void createTree(TreeNode root){
//        root = new TreeNode();
//    }

    //迭代法前序遍历
    public static List<Integer> preoderTraversal(TreeNode root){

        List<Integer> list = new ArrayList<>();
        if (root==null) {
            return list;
        }else {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.peek();
                stack.pop();
                list.add(node.val);
                if (node.right!=null) stack.push(node.right);
                if (node.left!=null) stack.push(node.left);
            }
        }
        return list;
    }

    /*
    * 后序遍历：与前序遍历相似
    * */
    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root==null)
            return list;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            stack.pop();
            list.add(node.val);
            if (node.left!=null) stack.push(node.left);
            if (node.right!=null) stack.push(node.right);
        }
        Collections.reverse(list);
        return list;
    }

    //迭代法 中序遍历
    public static List<Integer> midTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root==null)
            return list;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = root;
        while (curNode!=null||!stack.isEmpty()){
            if (curNode!=null){
                stack.push(curNode);
                curNode = curNode.left;
            }else {
                curNode = stack.peek();
                stack.pop();
                list.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return list;
    }

    /*
    * 层次遍历（迭代法）（自上而下遍历）
    * */
    public static List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        if (root!=null) que.offer(root);
        List<List<Integer>> return_List = new ArrayList<>();
        while (!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = que.peek();
                que.poll();
                list.add(node.val);
                if (node.left!=null)
                    que.offer(node.left);
                if (node.right!=null)
                    que.offer(node.right);
            }
            return_List.add(list);
        }
        return return_List;
    }

    /*
    * 层次遍历（自下而上遍历）
    * */
    public static List<List<Integer>> levelOrderReverse(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        if (root!=null) que.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!que.isEmpty()){
            int size = que.size();
            List<Integer> list1 = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = que.peek();
                que.poll();
                list1.add(node.val);
                if (node.left!=null)
                    que.offer(node.left);
                if (node.right!=null)
                    que.offer(node.right);
            }
            list.add(list1);
        }
        Collections.reverse(list);
        return list;
    }
    /*
    * 通过层次遍历的逻辑，实现二叉树最大深度
    * */
    public static int treeMaxDepth(TreeNode root){
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i=0;i<size;i++){
                TreeNode node = queue.peek();
                queue.poll();
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
        }
        return depth;
    }

    /*
    * 判断是否为对称树
    * */
    public static boolean isSymmetric(TreeNode root){
        if (root == null)
            return true;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root.left);que.offer(root.right);
        while (!que.isEmpty()){
            TreeNode leftNode = que.peek();
            que.poll();
            TreeNode rightNode = que.peek();
            que.poll();
            if (leftNode==null&&rightNode==null)
                continue;
            if ((leftNode!=null&&rightNode==null)||(leftNode==null&&rightNode!=null)||(rightNode.val!=leftNode.val))
                return false;
            que.offer(leftNode.left);que.offer(rightNode.right);
            que.offer(leftNode.right);que.offer(rightNode.left);
        }
        return true;
    }

    /*
    * 翻转二叉树：与对称树相似
    * */
    public static TreeNode invertTree(TreeNode root){
        if (root == null)
            return root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.poll();
            TreeNode left = n.left;
            n.left = n.right;
            n.right = left;
            if (n.left != null)
                stack.push(n.left);
            if (n.right != null)
                stack.push(n.right);
        }
        return root;
    }

    /*
    * leetcode 700 :二叉搜索树中的搜索
    * */
    public static TreeNode searchBST(TreeNode root,int val){
        if (root==null)
            return root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.poll();
            if (node.val==val)
                return node;
            if (node.left!=null)
                stack.push(node.left);
            if (node.right!=null)
                stack.push(node.right);
        }
        return null;
    }

    /*
    * leetcode 701：二叉搜索树中的插入操作
    * */
    public static TreeNode insertIntoBST(TreeNode root,int val){
        if (root==null){
            root = insertFunc(root,val);
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode n =stack.poll();
            if (n.val<val){
                TreeNode right = n.right;
                if (n.right==null)
                    n.right = insertFunc(n,val);
                else
                    stack.push(right);
            }else {
                TreeNode left = n.left;
                if (n.left==null)
                    n.left = insertFunc(n,val);
                else
                    stack.push(n.left);
            }
        }
        return root;
    }
    public static TreeNode insertFunc(TreeNode node,int val){
        node = new TreeNode(val);return node;
    }

    /*
    * LeetCode98 验证二叉搜索树通过BST中序遍历必然有序的特点判断
    * */
    public static boolean isValidBST(TreeNode root){
        if(root==null)
            return false;
        if(root.left==null&&root.right==null)
            return true;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode n = stack.poll();
            if(n.left!=null){
                if(n.left.val>n.val||n.left.val==n.val)
                    return false;
                stack.push(n.left);
            }
            if(n.right!=null){
                if(n.right.val<n.val||n.val==n.right.val)
                    return false;
                stack.push(n.right);
            }
        }
        return true;
    }

    /*
    * LeetCode111 二叉树最小深度
    * */
    public static int treeMinDepth(TreeNode root){
        if (root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left==null&&node.right==null)
                    return depth;
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
            }
        }
        return depth;
    }

    /*
    * LeetCode 236 二叉树最近公共祖先（递归）
    * */
    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        //base case
        if (root==null)
            return null;
        if (root==p||root==q)
            return root;

        //后序遍历递归框架
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //情景一：左右目标都在以root为根的树上
        if (left!=null&&right!=null)
            return root;
        //情景二：左右节点返回空说明没有匹配的目标返回空
        if (left==null&&right==null)
            return null;
        //情景三：左右目标只有一个在root为根的树上
        return left==null?right:left;
    }


    public static void main(String[] args) {
        TreeNode treeA = new TreeNode(5);
        TreeNode treeB = new TreeNode(4);
        TreeNode treeC = new TreeNode(6);
        TreeNode treeD = new TreeNode(1);
        TreeNode treeE = new TreeNode(2);
        TreeNode treeF = new TreeNode(7);
        TreeNode treeG = new TreeNode(8);
        treeA.left = treeB;treeA.right = treeC;
        treeB.left = treeD;treeB.right = treeE;
        treeC.left = treeF;treeC.right = treeG;
        List<Integer> list = preoderTraversal(treeA);
        System.out.println("前序遍历:");
        for (int i:list)
            System.out.print(i+" ");
        System.out.println();
        List<Integer> list1 = midTraversal(treeA);
        System.out.println("中序遍历:");
        for (int i:list1)
            System.out.print(i+" ");
        System.out.println();
        List<Integer> list2 = postorderTraversal(treeA);
        System.out.println("后序遍历:");
        for (int i:list2)
            System.out.print(i+" ");
        System.out.println();
        List<List<Integer>> list3 = levelOrder(treeA);
        System.out.println("层次遍历:");
        for (List<Integer> l:list3)
            for (int i:l)
                System.out.print(i+" ");
        System.out.println();
        System.out.println("二叉树最大深度:"+treeMaxDepth(treeA));
        System.out.println("是否为对称树:"+isSymmetric(treeA));
        int depth = treeMinDepth(treeA);
        System.out.println("二叉树最小深度:"+depth);
    }

}
