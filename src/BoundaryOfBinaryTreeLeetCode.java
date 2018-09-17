/*
Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1
Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].
Example 2
Input:
    ____1_____
   /          \
  2            3
 / \          /
4   5        6
   / \      / \
  7   8    9  10

Ouput:
[1,2,4,7,8,9,10,6,3]

Explanation:
The left boundary are node 1,2,4. (4 is the left-most node according to definition)
The leaves are node 4,7,8,9,10.
The right boundary are node 1,3,6,10. (10 is the right-most node).
So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTreeLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        result.add(root.val);
        if(isLeaf(root)) return result;
        TreeNode temp = root.left;
        while(temp!=null && !isLeaf(temp)){
            result.add(temp.val);
            if(temp.left!=null) temp=temp.left;
            else temp=temp.right;
        }
        dfsAddLeaves(root,result);
        temp=root.right;
        Stack<Integer> stack=new Stack<>();
        while(temp!=null && !isLeaf(temp)){
            stack.push(temp.val);
            if(temp.right!=null) temp=temp.right;
            else temp=temp.left;
        }
        while(!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    private static boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }

    private static void dfsAddLeaves(TreeNode node, List<Integer> result){
        if(node.left==null && node.right==null) {
            result.add(node.val);
            return;
        }
        if(node.left!=null) dfsAddLeaves(node.left,result);
        if(node.right!=null) dfsAddLeaves(node.right,result);
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
        System.out.println(boundaryOfBinaryTree(createTree()));

    }
}
