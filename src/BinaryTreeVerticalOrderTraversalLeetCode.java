/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */

import java.util.*;

public class BinaryTreeVerticalOrderTraversalLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class QueueElement{
        TreeNode node;
        int col;
        QueueElement(TreeNode node, int col){
            this.node = node;
            this.col = col;
        }
    }
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        HashMap<Integer,List<Integer>> result = new HashMap<>();
        Queue<QueueElement> queue = new LinkedList<>();
        queue.offer(new QueueElement(root,0));
        result.put(0,new ArrayList<>());
        result.get(0).add(root.val);
        int minKey = Integer.MAX_VALUE, maxKey=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            QueueElement cur= queue.poll();
            if(cur!=null){
                minKey=Math.min(minKey, cur.col);
                maxKey=Math.max(maxKey, cur.col);
                if(cur.node.left!=null){
                    queue.offer(new QueueElement(cur.node.left,cur.col-1));
                    if(!result.containsKey(cur.col-1))
                        result.put(cur.col-1,new ArrayList<>());
                    result.get(cur.col-1).add(cur.node.left.val);
                }
                if(cur.node.right!=null){
                    queue.offer(new QueueElement(cur.node.right,cur.col+1));
                    if(!result.containsKey(cur.col+1))
                        result.put(cur.col+1,new ArrayList<>());
                    result.get(cur.col+1).add(cur.node.right.val);
                }
            }
            else{
                if(!queue.isEmpty())
                    queue.offer(null);
            }
        }
        for(int i=minKey;i<=maxKey;i++){
            res.add(result.get(i));
        }
        return res;
    }

    public static void main(String args[]){
        TreeNode root= new TreeNode(3);
        root.left= new TreeNode(9);
        root.right= new TreeNode(8);
        root.left.left= new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res= verticalOrder(root);
        for(List<Integer>  l: res){
            System.out.println(l);
        }
    }
}
