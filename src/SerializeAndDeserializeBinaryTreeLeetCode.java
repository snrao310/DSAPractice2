import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
 * in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
 * another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to
 * a string and this string can be deserialized to the original tree structure.
 *
 */
public class SerializeAndDeserializeBinaryTreeLeetCode {

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

    public static void inOrder(TreeNode node, List<Integer> list){
        if(node==null) return;
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }

    public static void preOrder(TreeNode node, List<Integer> list){
        if(node==null) return;
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }


    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "NULL";
            String nullStr = "X";
            StringBuilder result = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            result.append(Integer.toString(root.val));
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                if(cur!=null){
                    if(cur.left!=null){
                        queue.offer(cur.left);
                        result.append(","+Integer.toString(cur.left.val));
                    }
                    else{
                        result.append("," + nullStr);
                    }
                    if(cur.right!=null){
                        queue.offer(cur.right);
                        result.append(","+Integer.toString(cur.right.val));
                    }
                    else{
                        result.append("," + nullStr);
                    }
                }
                else{
                    if(!queue.isEmpty())
                        queue.offer(null);
                }
            }
            return result.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("NULL")) return null;
            String[] parts = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root); queue.offer(null);
            int i=1;
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                if(cur!=null){
                    if(!parts[i].equals("X")){
                        cur.left = new TreeNode(Integer.parseInt(parts[i]));
                        queue.offer(cur.left);
                    }
                    if(!parts[i+1].equals("X")){
                        cur.right = new TreeNode(Integer.parseInt(parts[i+1]));
                        queue.offer(cur.right);
                    }
                    i+=2;
                }
                else{
                    if(!queue.isEmpty())
                        queue.offer(null);
                }
            }
            return root;
        }
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        Codec codec = new Codec();
        root=codec.deserialize(codec.serialize(root));
        List<Integer> in=new ArrayList<>();
        inOrder(root,in);
        List<Integer> pre=new ArrayList<>();
        preOrder(root,pre);
        for(int i: in) System.out.print(i+" ");
        System.out.println();
        for(int i: pre) System.out.print(i+" ");
    }
}
