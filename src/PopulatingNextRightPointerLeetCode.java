import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given a binary tree
 * struct TreeLinkNode {
 *  TreeLinkNode *left;
 *  TreeLinkNode *right;
 *  TreeLinkNode *next;
 * }
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should
 * be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two
 * children).
 *
 * For example,
 * Given the following perfect binary tree,
 *
 *       1
 *     /  \
 *    2    3
 *   / \  / \
 *  4  5  6  7
 *
 * After calling your function, the tree should look like:
 *
 *       1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \  / \
 *  4->5->6->7 -> NULL
 *
 */


public class PopulatingNextRightPointerLeetCode {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    //BFS solution. BFS is actually O(v+e). But for trees e<=v-1. so its O(v) ie O(n). But its not in place since it uses Queue.
    public static void connect_BFS(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root); queue.offer(null);
        TreeLinkNode prev=null;
        while(!queue.isEmpty()){
            TreeLinkNode cur = queue.poll();
            if(cur!=null) {
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                if(prev!=null)
                    prev.next=cur;
                prev=cur;
            }
            else{
                prev=null;
                if(!queue.isEmpty())
                    queue.offer(null);
            }
        }
    }


    //Only for prefect binary tree. all leaves at same level. Also not constant space since recursion stack takes O(logn) space.
    //Tail recursion (no steps after recursive call) is optimized by some compilers to take O(1) space but Java doesn't optimize.
    public static void connect_recursive(TreeLinkNode root){
        if(root == null)
            return;
        if(root.left!=null && root.right!=null)
            root.left.next=root.right;
        if(root.next!=null && root.right!=null && root.next.left!=null)
            root.right.next=root.next.left;

        connect_recursive(root.left);
        connect_recursive(root.right);
    }

    //Iterative O(n) time. Constant space. Best solution Awesome!!!
    public static void connect(TreeLinkNode root) {
        TreeLinkNode first = root;
        while(first!=null){
            TreeLinkNode temp = first;
            while(temp!=null){
                if(temp.left!=null) temp.left.next=temp.right;
                if(temp.right!=null && temp.next!=null) temp.right.next=temp.next.left;
                temp=temp.next;
            }
            first=first.left;
        }
    }

    public static void testResult(TreeLinkNode root){
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeLinkNode cur =queue.poll();
            if(cur.left!=null)
                queue.offer(cur.left);
            System.out.print("\n"+cur.val+" ");
            cur=cur.next;
            while(cur!=null){
                System.out.print(cur.val+" ");
                cur=cur.next;
            }
        }
    }

    public static void main(String args[]){
        TreeLinkNode root = new TreeLinkNode(1);
        root.left=new TreeLinkNode(2);
        root.right=new TreeLinkNode(3);
        root.left.left=new TreeLinkNode(4);
        root.left.right=new TreeLinkNode(5);
        root.right.left=new TreeLinkNode(6);
        root.right.right=new TreeLinkNode(7);
        testResult(root);
        connect(root);
        System.out.println("\n");
        testResult(root);
    }


}
