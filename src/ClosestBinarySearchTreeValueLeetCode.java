/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4

 */

public class ClosestBinarySearchTreeValueLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    public static int closestValue(TreeNode root, double target) {
        return findClosest(root,target);
    }

    private static int findClosest(TreeNode root, double target){
        if(target==root.val) return root.val;
        if(root.val>target){
            if(root.left!=null){
                int closest = findClosest(root.left,target);
                if(root.val-target>Math.abs(target-closest))
                    return closest;
            }
            return root.val;
        }
        else{
            if(root.right!=null){
                int closest = findClosest(root.right,target);
                if(target-root.val>Math.abs(closest-target))
                    return closest;
            }
            return root.val;
        }
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

    public static void main(String args[]){
        System.out.println(closestValue(createTree(),2.678));

    }
}
