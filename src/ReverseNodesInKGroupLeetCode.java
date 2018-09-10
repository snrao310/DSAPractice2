/**
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 */
public class ReverseNodesInKGroupLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        ListNode temp=head, headPrev=new ListNode(-1), tempPrev=headPrev;
        headPrev.next=head;
        while(temp!=null){
            ListNode temp1=temp,temp2=temp.next,temp3=(temp2==null)?null:temp2.next;
            int i=0;
            while(temp!=null && i!=k){
                temp=temp.next;
                i++;
            }
            if(i!=k) return headPrev.next;
            temp1.next=temp;
            while(temp2!=null && temp2!=temp){
                temp2.next=temp1;
                temp1=temp2; temp2=temp3; temp3=(temp2==null)?null:temp2.next;
            }
            ListNode tempPrevNext=tempPrev.next;
            tempPrev.next=temp1;
            tempPrev=tempPrevNext;
        }
        return headPrev.next;
    }

    public static void main(String args[]){
        ListNode first=new ListNode(1);
        first.next=new ListNode(2);
        first.next.next=new ListNode(3);
        first.next.next.next=new ListNode(4);
        first.next.next.next.next=new ListNode(5);
        first=reverseKGroup(first,2);
        while(first!=null) {
            System.out.print(first.val + " ");
            first = first.next;
        }
    }
}
