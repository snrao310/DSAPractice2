/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
 * first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersIILeetCode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0, len2 = 0, carry = 0;
        ListNode t1 = l1, t2 = l2, result = new ListNode(0), t3 = result;
        while (t1 != null || t2 != null) {
            if (t1 != null) {
                len1++;
                t1 = t1.next;
            }
            if (t2 != null) {
                len2++;
                t2 = t2.next;
            }
        }
        t1=l1; t2=l2;
        if (len2 > len1) { t1 = l2;t2 = l1; int temp= len1; len1 = len2; len2 = temp;}
        while (t1 != null) {
            ListNode t4 = new ListNode(t1.val);
            t4.next = t3;
            t1 = t1.next;
            if(len1<=len2){
                t4.val+=t2.val;
                t2 = t2.next;
            }
            t3 = t4;
            len1--;
        }
        t1 = t3; t2 = t1.next; t3 = (t2 == null) ? null : t2.next; t1.next = null;
        while (t2 != null) {
            t1.val += carry;
            carry = 0;
            if (t1.val > 9)
                carry = 1;
            t1.val %= 10;
            t2.next = t1;
            t1 = t2; t2 = t3; t3 = (t2 == null) ? null : t2.next;
        }
        if (carry != 0) t1.val += 1;
        if (result.val == 0)
            return result.next;
        else return result;
    }


    public static void main(String args[]) {
        ListNode first = new ListNode(7);
        first.next = new ListNode(2);
        first.next.next = new ListNode(4);
        first.next.next.next = new ListNode(3);
        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);
        first = addTwoNumbers(first, second);
        while (first != null) {
            System.out.print(first.val + " ");
            first = first.next;
        }
    }
}
