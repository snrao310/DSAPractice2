import java.util.*;

/**
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 */
public class TopKFrequentElementsLeetCode {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i: nums){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });

        for(int key: freqMap.keySet()){
            if(minHeap.size()<k || minHeap.peek()[1]<freqMap.get(key))
                minHeap.offer(new int[]{key,freqMap.get(key)});
            if(minHeap.size()>k)
                minHeap.poll();
        }

        for(int[] i:minHeap){
            result.add(i[0]);
        }
        return result;
    }


    //O(n) time, coz List is actually an arraylist, so average time to add is o(1).
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer>[] freqToNums=new List[nums.length+1];
        HashMap<Integer,Integer> numsToFreq=new HashMap<>();

        for(int i=0;i<nums.length;i++)
            numsToFreq.put(nums[i],numsToFreq.getOrDefault(nums[i],0)+1);

        for(int i:numsToFreq.keySet()){
            if(freqToNums[numsToFreq.get(i)]==null)
                freqToNums[numsToFreq.get(i)]=new ArrayList<>();
            freqToNums[numsToFreq.get(i)].add(i);
        }

        List<Integer> result=new ArrayList<>();
        int size=0;
        for(int i=freqToNums.length-1;i>=0;i--){
            if(freqToNums[i]!=null) {
                result.addAll(freqToNums[i]);
                if(result.size()>k) break;
            }
        }
        return result.subList(0,k);
    }

    public static void main(String args[]){
        List<Integer> list=topKFrequent2(new int[]{4,1,-1,2,-1,2,3},2);
        for(int i:list) System.out.print(i+" ");
    }
}
