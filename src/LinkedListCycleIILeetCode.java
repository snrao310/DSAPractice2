/**
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 */
public class LinkedListCycleIILeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow=(head==null)?head:head.next, fast=(slow==null)?slow:slow.next;
        while(fast!=null){
            if(fast==slow)
                break;
            slow=slow.next;
            fast=(fast.next==null)?fast.next:fast.next.next;
        }

        if(fast==null) return null;
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next=head.next;
        ListNode cycleStart= detectCycle(null);
        if(cycleStart==null)
            System.out.println("null");
        else
            System.out.println(cycleStart.val);
    }
}
