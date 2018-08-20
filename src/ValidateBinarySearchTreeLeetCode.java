import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 */
public class ValidateBinarySearchTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        TreeNode two= new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five= new TreeNode(5);
        root.left=one; root.right=five; five.left=four; one.right=two;
        return root;
    }

    public static boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        List<Integer> sorted = new ArrayList<>();
        inOrderTraversal(root, sorted);
        long prev = ((long)Integer.MIN_VALUE)-1;
        for(long i: sorted){
            if(i<=prev) return false;
            prev = i;
        }
        return true;
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> list){
        if(root == null) return;
        inOrderTraversal(root.left,list);
        list.add(root.val);
        inOrderTraversal(root.right,list);
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        System.out.print(isValidBST(root));
    }
}
