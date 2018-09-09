import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 *
 * You may only use constant extra space.
 *
 */
public class PopulatingNextRightPointersIILeetCode {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {val = x;}
    }

    //Iterative O(n) time. Constant space.
    public static void connect(TreeLinkNode root) {
        TreeLinkNode first = root;
        while(first!=null){
            TreeLinkNode temp=first, prev =null;
            first =null;
            while(temp!=null){
                if(temp.left!=null){
                    if(prev==null) first = temp.left;
                    else prev.next=temp.left;
                    prev=temp.left;
                }
                if(temp.right!=null){
                    if(prev==null) first = temp.right;
                    else prev.next=temp.right;
                    prev=temp.right;
                }
                temp=temp.next;
            }
        }
    }

    public static TreeLinkNode createTree(){
        TreeLinkNode root=new TreeLinkNode(3);
        TreeLinkNode one=new TreeLinkNode(1);
        TreeLinkNode two= new TreeLinkNode(2);
        TreeLinkNode four=new TreeLinkNode(4);
        TreeLinkNode five= new TreeLinkNode(5);
        root.left=one; root.right=five; five.left=four; one.right=two;
        return root;
    }

    public static void check(TreeLinkNode root){
        Queue<TreeLinkNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeLinkNode prev=null;
        while(!queue.isEmpty()){
            TreeLinkNode cur=queue.poll();
            if(prev==null){
                TreeLinkNode temp=cur;
                while(temp!=null){
                    System.out.print(temp.val+" ");
                    temp=temp.next;
                }
                System.out.println();
            }
            if(cur!=null){
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            else{
                if(!queue.isEmpty())
                    queue.offer(null);
            }
            prev=cur;
        }
    }

    public static void main(String args[]){
        TreeLinkNode root=createTree();
        connect(root);
        check(root);
    }
}
