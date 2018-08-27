import sun.reflect.generics.tree.Tree;

/**
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *      1
 *     / \
 *    2   2
 *     \   \
 *      3    3
 *
 */
public class SymmetricBinaryTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){this.val=val;}
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirrorImage(root.left, root.right);
    }

    private static boolean isMirrorImage(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val) return false;
        return isMirrorImage(root1.left, root2.right) && isMirrorImage(root1.right, root2.left);
    }

    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2); root.right=new TreeNode(2);
        System.out.println(isSymmetric(root));
        root.left.left=new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
}
