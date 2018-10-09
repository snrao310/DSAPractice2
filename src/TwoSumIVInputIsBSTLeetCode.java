/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */

import java.util.HashSet;

public class TwoSumIVInputIsBSTLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        TreeNode two= new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five= new TreeNode(5);
        root.left=two; two.left=one; root.right=five; five.left=four;
        return root;
    }

    public static boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findSum(root,k,set);
    }

    private static boolean findSum(TreeNode root, int k, HashSet<Integer> set){
        if(root==null) return false;
        int rem=k-root.val;
        if(set.contains(rem)) return true;
        set.add(root.val);
        return findSum(root.left, k, set) || findSum(root.right, k, set);
    }

    public static void main(String args[]){
        System.out.println(findTarget(createTree(),8));

    }
}
