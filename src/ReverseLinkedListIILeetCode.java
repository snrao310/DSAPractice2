/**
 *
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 *
 */
public class ReverseLinkedListIILeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tempHead=new ListNode(-1);
        tempHead.next= head;
        ListNode mPrev=tempHead, nPrev=tempHead, temp=head;
        int index=1;
        while(temp!=null){
            if(index>m && index<=n){
                ListNode mNode=mPrev.next;
                ListNode nNext=temp.next;
                mPrev.next=temp;
                temp.next=mNode;
                nPrev.next=nNext;
                temp=nNext;
            }
            else{
                temp=temp.next;
                nPrev=nPrev.next;
                mPrev=(index==m)?mPrev:mPrev.next;
            }
            index++;
        }
        return tempHead.next;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head = reverseBetween(head,1,5);
        while(head!=null){
            System.out.print(head.val + " ");
            head=head.next;
        }
    }
}
