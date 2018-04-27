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

    //fast pointer will always meet slow pointer if there is a cycle. Just like faster runner will pass slower runner
    //in a circular track. To find the meeting point:
    //Let D = number of nodes from head to start of cycle.
    //Let k = number of nodes from start of cycle to meeting point.
    //Let N = number of nodes traveled by slow pointer.
    //Then 2N = number of nodes traveled by fast pointer.
    //Let C = number of nodes in cycle.
    // N = D + Ci + k ,where i is the number of cycles covered by slow pointer.
    // 2N = D + Cj + k ,where j is the number of cycles covered by fast pointer.
    // implies 2D + 2Ci + 2k = D + Cj + k
    // implies D = C(j - 2i) - k
    //which means when the if the pointer moves D nodes from the meeting point, it will reach the start of the cycle.

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
