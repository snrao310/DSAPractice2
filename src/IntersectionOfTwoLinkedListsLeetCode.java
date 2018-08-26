/**
 * Created by S N Rao on 4/21/2017.
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                     ↘
 *                       c1 → c2 → c3
 *                     ↗
 * B:   b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
public class IntersectionOfTwoLinkedListsLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){val=x;}
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA, temp2=headB;
        int len1=0,len2=0,i=0;
        while(temp1!=null){
            temp1=temp1.next;
            len1++;
        }
        while(temp2!=null){
            temp2=temp2.next;
            len2++;
        }
        if(len1<len2){
            temp1=headB; temp2=headA;
        }
        else{
            temp1=headA;temp2=headB;
        }
        while(i<Math.abs(len1-len2)){
            temp1=temp1.next;
            i++;
        }
        while(temp1!=null){
            if(temp1==temp2) return temp1;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }

    private static ListNode advance(ListNode head, int count){
        for(int i=0;i<count;i++){
            head=head.next;
        }
        return head;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(5); ListNode two=new ListNode(6); two.next=new ListNode(7); one.next=two;
        ListNode three=new ListNode(3); three.next=new ListNode(4); three.next.next=two;
        System.out.println(getIntersectionNode(one,three).val); //6
    }
}
