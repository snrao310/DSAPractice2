import java.util.*;

/**
 * Created by S N Rao on 1/31/2017.
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */

public class BinaryTreeLevelOrderTraversalLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); queue.offer(null);
        while(queue.peek()!=null){
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if(cur.left!=null && !visited.contains(cur.left))
                queue.offer(cur.left);
            if(cur.right!=null && !visited.contains(cur.right))
                queue.offer(cur.right);
            if(queue.peek() == null){
                queue.offer(null);
                queue.poll();
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }


    public static void main(String args[]){
        TreeNode root= new TreeNode(3);
        root.left= new TreeNode(5);
        root.right= new TreeNode(6);
        root.left.left= new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(16);
        List<List<Integer>> res= levelOrder(null);
        for(List<Integer>  l: res){
            System.out.println(l);
        }
    }

}
