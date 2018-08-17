import java.util.*;

/**
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 *
 */
public class BinaryTreeZigzagLevelOrderTraversalLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); queue.offer(null);
        boolean isRightToLeft= false;
        List<Integer> list = new ArrayList();
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur!=null){
                list.add(cur.val);
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            else{
                if(!queue.isEmpty())
                    queue.offer(null);
                if(isRightToLeft)
                    Collections.reverse(list);
                isRightToLeft=!isRightToLeft;
                result.add(list);
                list=new ArrayList();
            }
        }
        return result;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        List<List<Integer>> list=zigzagLevelOrder(root);
        for(List<Integer> l:list){
            for(int i:l)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
