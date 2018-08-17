import java.util.List;

/**
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 */
public class AddTwoNumbersLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2, resultPrev = new ListNode(-1), temp3=resultPrev;
        int sum=0,carry=0;
        while(temp1!=null){
            sum=temp1.val+carry;
            carry =0;
            if(temp2!=null){
                sum+=temp2.val;
                temp2=temp2.next;
            }
            if(sum>9){
                carry= sum/10;
                sum%=10;
            }
            temp1=temp1.next;
            if(temp1==null && temp2!=null){
                temp1=temp2; temp2=null;
            }
            temp3.next = new ListNode(sum);
            temp3=temp3.next;
        }
        if(carry!=0){
            temp3.next = new ListNode(carry);
        }
        return resultPrev.next;
    }

    public static void main(String args[]){
        ListNode first=new ListNode(1);
        first.next=new ListNode(4);
        first.next.next=new ListNode(9);
        ListNode second=new ListNode(5);
        second.next=new ListNode(6);
        second.next.next=new ListNode(4);
        first=addTwoNumbers(first,second);
        while(first!=null){
            System.out.print(first.val+" ");
            first=first.next;
        }
    }
}
