import java.util.*;

/**
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
 *
 */
public class BinaryTreeRightSideViewLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    //LevelOrderTraversal
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); queue.offer(null);
        TreeNode cur=null,prev=null;
        while(!queue.isEmpty()){
            prev=cur;
            cur = queue.poll();
            if(cur!=null){
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            else{
                result.add(prev.val);
                if(!queue.isEmpty()) queue.offer(null);
            }
        }
        return result;
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

    public static void main(String args[]){
        TreeNode root=createTree();
        List<Integer> l=rightSideView(root);
        for(int j=0;j<l.size();j++)
            System.out.print(l.get(j)+" ");
    }
}
