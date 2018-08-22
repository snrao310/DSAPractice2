import java.util.List;

/**
 *
 * Reverse a singly linked list.
 *
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 */
public class ReverseLinkedListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){val=x;}
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode t1= head, t2=t1.next, t3=(t2==null)?null:t2.next;
        t1.next=null;
        while(t2!=null){
            t2.next = t1;
            t1=t2; t2=t3; t3=(t3==null)?null:t3.next;
        }
        return t1;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseListRecursive(nextNode);
        nextNode.next=head; head.next=null;
        return newHead;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(1); one.next=new ListNode(2); one.next.next=new ListNode(3);
        one=reverseList(one);

        ListNode temp=one;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();

        one=reverseListRecursive(one);
        temp=one;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
}
