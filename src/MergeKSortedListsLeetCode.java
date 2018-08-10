import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 */

public class MergeKSortedListsLeetCode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    //Complexity: Each node in the list is added once and polled once from the heap. The size of the heap is the number
    //of list to merge (the size of lists array: K). So the complexity is O(nlogK), where n is number of elements and K
    //is number of lists to merge.
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });
        for(ListNode node: lists){
            if(node!=null)
                heap.offer(node);
        }

        ListNode headPrev=new ListNode(-1), temp=headPrev;
        while(!heap.isEmpty()){
            ListNode cur = heap.poll();
            temp.next=cur;
            temp=temp.next;
            if(cur.next!=null)
                heap.offer(cur.next);
        }
        return headPrev.next;
    }


    public static void main(String args[]){
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(6);
        l1.next.next.next=new ListNode(9);

        ListNode l2=new ListNode(0);
        l2.next=new ListNode(2);
        l2.next.next=new ListNode(3);
        l2.next.next.next=new ListNode(12);

        ListNode l3=new ListNode(4);
        l3.next=new ListNode(8);
        l3.next.next=new ListNode(9);
        l3.next.next.next=new ListNode(11);

        ListNode[] lists=new ListNode[3];
        lists[0]=l1; lists[1]=l2; lists[2]=l3;

        ListNode merged=mergeKLists(lists);
        while(merged!=null){
            System.out.print(merged.val+" ");
            merged=merged.next;
        }
    }
}
