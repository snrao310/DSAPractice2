import java.util.List;

/**
 *
 * Sort a linked list using insertion sort.
 *
 */

public class InsertionSortListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head==null) return head;
        ListNode headPrev = new ListNode(-1);
        headPrev.next=head;
        ListNode temp=head.next, tempPrev=head, tempNext=(temp==null)?null:temp.next;
        while(temp!=null){
            ListNode prev=headPrev, next=headPrev.next;
            while(next!=temp && next.val<temp.val){
                prev=next;
                next=next.next;
            }
            if(next!=temp){
                tempPrev.next=tempNext;
                prev.next=temp;
                temp.next=next;
                temp=tempPrev;
            }
            tempPrev=temp; temp=tempNext; tempNext=(temp==null)?null:temp.next;
        }
        return headPrev.next;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(5);
        head.next=new ListNode(1);
        head.next.next=new ListNode(4);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(2);
        head = insertionSortList(head);
        while(head!=null){
            System.out.print(head.val);
            head=head.next;
        }
    }
}
