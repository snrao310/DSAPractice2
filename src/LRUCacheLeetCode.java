import java.util.HashMap;

/**
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - [Set] or [insert the value if the key is not already present]. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 * LRUCache cache = new LRUCache( 2 );
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 */

public class LRUCacheLeetCode {

    public static class LRUCache {

        int capacity, curSize;
        HashMap<Integer, ListNode> keyToNode;
        private class ListNode{
            int key;
            int value;
            ListNode prev;
            ListNode next;
            ListNode(int k, int v){
                key=k;
                value = v;
            }
        }
        ListNode head,tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            keyToNode = new HashMap<>();
            curSize = 0;
            head = null;
            tail = null;
        }

        public int get(int key) {
            if(keyToNode.containsKey(key)){
                ListNode node = keyToNode.get(key);
                updateNode(node);
                return node.value;
            }
            else{
                return -1;
            }
        }

        private void updateNode(ListNode node){
            if(head == node) return;
            if(tail == node && node.prev!=null) tail = node.prev;
            if(node.prev!=null) node.prev.next = node.next;
            if(node.next!=null) node.next.prev = node.prev;
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }

        private void evict(){
            tail.prev.next = null;
            keyToNode.remove(tail.key);
            tail = tail.prev;
        }

        public void put(int key, int value) {
            if(capacity==0) return;
            if(keyToNode.containsKey(key)){
                ListNode node = keyToNode.get(key);
                node.value=value;
                updateNode(node);
            }
            else{
                curSize++;
                ListNode node = new ListNode(key,value);
                if(head==null) {
                    head = node;
                    tail = node;
                }
                updateNode(node);
                keyToNode.put(key,node);
            }

            if(curSize>capacity){
                evict();
                curSize--;
            }
        }
    }

    public static void main(String args[]){
        /**
         * Your LRUCache object will be instantiated and called as such:
         * LRUCache obj = new LRUCache(capacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
