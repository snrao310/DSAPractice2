import java.util.List;

/**
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking
 * about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 *
 */
public class OddEvenLinkedListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode t1=head, t2=head.next;
        while(t2!=null && t2.next!=null){
            ListNode even=t1.next;
            ListNode odd=t2.next;
            ListNode oddNext=odd.next;
            t1.next=odd;
            t2.next=oddNext;
            odd.next=even;
            t1=t1.next; t2=t2.next;
        }
        return head;
    }

    public static void main(String args[]){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        head=oddEvenList(head);
        while(head!=null){
            System.out.print(head.val);
            head=head.next;
        }
    }
}
