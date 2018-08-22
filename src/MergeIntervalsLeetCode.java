import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 */
public class MergeIntervalsLeetCode {

    public static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals.size()==0) return result;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1,Interval o2){
                return o1.start-o2.start;
            }
        });
        int curStart=Integer.MIN_VALUE, curEnd = Integer.MIN_VALUE;
        for(int i=0;i<intervals.size();i++){
            Interval cur = intervals.get(i);
            if(cur.start>curEnd){
                if(i!=0) result.add(new Interval(curStart, curEnd));
                curStart = cur.start; curEnd= cur.end;
            }
            else{
                curEnd = Math.max(curEnd, cur.end);
            }
        }
        result.add(new Interval(curStart,curEnd));
        return result;

    }

    public static void main(String args[]){
        List<Interval> list=new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        list=merge(list);
        for(Interval i: list){
            System.out.println("["+i.start+","+i.end+"]");
        }
    }
}
