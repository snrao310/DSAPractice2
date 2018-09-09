/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIILeetCode {


     public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
     }


     //my solution with heap. O(nlogn) complexity. O(n) space complexity.
    public static int minMeetingRooms(Interval[] intervals) {
        if(intervals.length==0) return 0;
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.end-o2.end;
            }
        });
        Arrays.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                if(o1.start==o2.start) return o1.end-o2.end;
                return o1.start-o2.start;
            }
        });
        int rooms=0;

        for(int i=0;i<intervals.length;i++){
            while(!minHeap.isEmpty() && minHeap.peek().end<=intervals[i].start)
                minHeap.poll();
            minHeap.offer(intervals[i]);
            rooms=Math.max(rooms, minHeap.size());
        }
        return rooms;
    }


    //or another solution. this is also same time and space complexity but its cool
    public static int minMeetingRooms2(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }

    public static void main(String args[]){
         System.out.println(minMeetingRooms(new Interval[]{new Interval(0,30), new Interval(5,10), new Interval(15,20)}));
    }
}
