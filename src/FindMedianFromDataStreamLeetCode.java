import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 * <p>
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * <p>
 * For example:
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class FindMedianFromDataStreamLeetCode {

    public static class MedianFinder {

        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        public void addNum(int num) {
            if (minHeap.size() == 0) {
                minHeap.offer(num);
                return;
            }
            if (num > minHeap.peek()) minHeap.offer(num);
            else maxHeap.offer(num);

            if (maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());
            else if (minHeap.size() > maxHeap.size() + 1) maxHeap.offer(minHeap.poll());
        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size()) return minHeap.peek();
            else return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

    }


    public static void main(String args[]) {
        /**
         * Your MedianFinder object will be instantiated and called as such:
         * MedianFinder obj = new MedianFinder();
         * obj.addNum(num);
         * double param_2 = obj.findMedian();
         */
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        obj.addNum(-2);
        obj.addNum(-3);
        System.out.print(obj.findMedian() + " ");
        obj.addNum(4);
        obj.addNum(6);
        obj.addNum(4);
        System.out.print(obj.findMedian());
    }
}
