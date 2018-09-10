/*
Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:

HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301);
Follow up:
What if the number of hits per second could be very large? Does your design scale?
 */

public class DesignHitCounterLeetCode {

    static class HitCounter {

        private class ListNode{
            int timestamp;
            int hits;
            ListNode next;
            ListNode(int t,int h){
                timestamp=t; hits=h;
            }
        }

        int curHits;
        ListNode nowNode,firstNode;

        /** Initialize your data structure here. */
        public HitCounter() {
            nowNode = new ListNode(0,0);
            firstNode=nowNode;
            curHits=0;
        }

        private void updateFirstNode(int timestamp){
            while(firstNode.timestamp<=(timestamp-300)){
                curHits-=firstNode.hits;
                firstNode=firstNode.next;
            }
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            curHits++;
            if(timestamp>nowNode.timestamp){
                nowNode.next=new ListNode(timestamp,1);
                nowNode=nowNode.next;
                updateFirstNode(timestamp);
            }
            else
                nowNode.hits++;
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            if(timestamp>nowNode.timestamp){
                nowNode.next=new ListNode(timestamp,0);
                nowNode=nowNode.next;
                updateFirstNode(timestamp);
            }
            return curHits;
        }
    }


    public static void main(String args[]){
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(300);
        System.out.println(counter.getHits(300));
        System.out.println(counter.getHits(301));
    }
}
