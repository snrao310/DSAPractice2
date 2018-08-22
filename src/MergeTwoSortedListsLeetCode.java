import java.util.List;

/**
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
 * nodes of the first two lists.
 *
 */
public class MergeTwoSortedListsLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val=val;}
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headPrev = new ListNode(-1), temp = headPrev, temp1 = l1, temp2 = l2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.next = temp1;
                temp1=temp1.next;
            }
            else{
                temp.next = temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        temp.next = (temp1==null)? temp2: temp1;
        return headPrev.next;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(1);
        one.next=new ListNode(3);
        one.next.next=new ListNode(6);
        ListNode two=new ListNode(2);
        two.next=new ListNode(4);
        ListNode three=mergeTwoLists(one, two);
        while (three!=null){
            System.out.print(three.val+" ");
            three=three.next;
        }
    }
}
