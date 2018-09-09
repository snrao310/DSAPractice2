import sun.reflect.generics.tree.Tree;

/**
 *
 * Given a binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * For example:
 * Given the below binary tree,
 *
 *      1
 *     / \
 *    2   3
 *
 * Return 6.
 *
 */
public class BinaryTreeMaximumPathSumLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(-2);
        TreeNode one=new TreeNode(1);
        root.left=one;
        return root;
    }

    static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        if(root==null) return 0;
        maxOneSidePath(root);
        return maxSum;
    }

    private static int maxOneSidePath(TreeNode root){
        if(root==null) return 0;
        int leftMax = maxOneSidePath(root.left);
        int rightMax = maxOneSidePath(root.right);
        maxSum = getMax(new int[]{maxSum, leftMax + root.val, rightMax + root.val, leftMax + rightMax + root.val, root.val});
        return getMax(new int[]{leftMax+root.val,rightMax+root.val, root.val});
    }

    private static int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i: nums) max = Math.max(max,i);
        return max;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        System.out.print(maxPathSum(root));
    }

}
