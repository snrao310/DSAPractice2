/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 */

import java.util.*;

public class TopKFrequentWordsLeetCode {

    private static class StringCountPair{
        String string;
        int count;
        StringCountPair(String s, int c){
            string = s;
            count = c;
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,StringCountPair> map=new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String s:words) {
            if(!map.containsKey(s)) map.put(s,new StringCountPair(s,0));
            map.get(s).count++;
        }
        PriorityQueue<StringCountPair> minHeap = new PriorityQueue<>(new Comparator<StringCountPair>(){
            @Override
            public int compare(StringCountPair o1,StringCountPair o2){
                if(o1.count==o2.count)
                    return o2.string.compareTo(o1.string);
                return o1.count-o2.count;
            }
        });

        for(String s: map.keySet()){
            minHeap.offer(map.get(s));
            if(minHeap.size()>k) minHeap.poll();
        }

        while(!minHeap.isEmpty()) result.add(minHeap.poll().string);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args){
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
    }
}
