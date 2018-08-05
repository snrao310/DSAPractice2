import java.util.HashMap;

/*

 */
public class CopyListWithRandomPointerLeetCode {

    public static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode,RandomListNode> oldToNew = new HashMap<>();
        RandomListNode tempOld = head.next;
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode tempNew = newHead;
        oldToNew.put(head,newHead);
        while(tempOld!=null){
            RandomListNode newNode = new RandomListNode(tempOld.label);
            tempNew.next = newNode;
            tempNew = newNode;
            oldToNew.put(tempOld,tempNew);
            tempOld = tempOld.next;
        }
        tempOld=head; tempNew=newHead;
        while(tempOld!=null){
            RandomListNode randomNode = tempOld.random;
            tempNew.random = oldToNew.get(randomNode);
            tempOld = tempOld.next; tempNew = tempNew.next;
        }
        return newHead;
    }

    public static void main(String args[]){
        RandomListNode head=new RandomListNode(1);
        head.next=new RandomListNode(2);
        head.next.next=new RandomListNode(3);
        head.random=head.next.next;
        head.next.next.random=head.next;
        head=copyRandomList(head);
        RandomListNode temp=head;
        while(temp!=null){
            System.out.print(temp.label+" ");
            temp=temp.next;
        }
        System.out.println();
        while(head!=null){
            System.out.print(head.label+" ");
            head=head.random;
        }
    }


}
