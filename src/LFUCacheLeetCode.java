import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following
 * operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - [Set] or [insert the value if the key is not already present]. When the cache reaches its capacity, it
 * should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when
 * there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 * LFUCache cache = new LFUCache( 2 )
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 */
public class LFUCacheLeetCode {

    //One important point not mentioned in the question is the definition of "Use". According to the test cases, both put
    //and get (not just get) are considered use. So if a new key is added, its freq is 1, and more importantly, when a
    //key's value is updated, its frequency increases.

    //Idea is to use 3 hashmaps. The first two are obvious. The freqToKeys hashmap stores a mapping from frequencies to
    //a hashset of keys having that frequency. But its crucial that the mapping is not to a normal hashset but a
    //LinkedHashSet. A linked hashset is same as a hashset but the objects being inserted in the hashset are also connected
    //by a doubly linked list. Insert, delete, retrieve all use normal hashset functions O(1). Only iteration uses this
    //extra doubly linked list pointer connecting the hashset objects to iterate in the order they were inserted. This
    //helps us because among elements having the same frequency, we want the one that was inserted first (least recently).
    //
    public static class LFUCache {

        HashMap<Integer,Integer> keyToVal;
        HashMap<Integer,Integer> keyToFreq;
        HashMap<Integer,LinkedHashSet<Integer>> freqToKeys;
        int capacity, minFreq;

        public LFUCache(int capacity) {
            minFreq=0; this.capacity=capacity;
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
        }

        public int get(int key) {
            if(!keyToVal.containsKey(key)) return -1;
            int freq = keyToFreq.get(key);
            keyToFreq.put(key, freq+1);
            freqToKeys.get(freq).remove(key);
            if(freqToKeys.get(freq+1)==null)
                freqToKeys.put(freq+1, new LinkedHashSet<>());
            freqToKeys.get(freq+1).add(key);
            if(minFreq==freq && freqToKeys.get(freq).isEmpty())
                minFreq++;
            return keyToVal.get(key);
        }

        public void put(int key, int value) {
            if(capacity==0) return;
            if(keyToVal.containsKey(key)){
                keyToVal.put(key,value);
                get(key);
                return;
            }
            if(keyToVal.size()==capacity){
                int keyToDel= freqToKeys.get(minFreq).iterator().next();
                keyToVal.remove(keyToDel);
                keyToFreq.remove(keyToDel);
                freqToKeys.get(minFreq).remove(keyToDel);
            }
            keyToVal.put(key,value);
            keyToFreq.put(key,1);
            if(freqToKeys.get(1)==null)
                freqToKeys.put(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            minFreq=1;
        }
    }

    public static void main(String args[]){
        /**
         * Your LFUCache object will be instantiated and called as such:
         * LFUCache obj = new LFUCache(capacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */

        LFUCache cache=new LFUCache(2);
        cache.put(1,1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);                        // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}
