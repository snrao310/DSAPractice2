import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by S N Rao on 1/31/2017.
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of
 * being returned.
 *
 */
public class InsertDeleteGetRandomO1LeetCode {

    public static class RandomizedSet {

        HashMap<Integer,Integer> valToInd;
        List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            valToInd = new HashMap<>();
            list=new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(valToInd.containsKey(val)) return false;
            valToInd.put(val,list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!valToInd.containsKey(val)) return false;
            int ind = valToInd.get(val);
            int valToMove = list.get(list.size()-1);
            valToInd.put(valToMove,ind);
            valToInd.remove(val);
            list.set(ind,valToMove);
            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int rand = (int)(Math.random()*list.size());
            return list.get(rand);
        }
    }

    public static void main(String args[]){

        /**
         * Your RandomizedSet object will be instantiated and called as such:
         * RandomizedSet obj = new RandomizedSet();
         * boolean param_1 = obj.insert(val);
         * boolean param_2 = obj.remove(val);
         * int param_3 = obj.getRandom();
         */

        RandomizedSet obj=new RandomizedSet();
        System.out.println("Inserting 0: "+obj.insert(0));
        System.out.println("Removing 0: "+obj.remove(0));
        System.out.println("Inserting -1: "+obj.insert(-1));
        System.out.println("Removing 0: "+obj.remove(0));
        System.out.println("Random: "+obj.getRandom());

    }
}
