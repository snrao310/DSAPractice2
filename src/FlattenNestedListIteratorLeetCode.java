/**
 * Created by S N Rao on 12/16/2016.
 *
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Code is commented here coz internal implementation of NestedInteger is not provided by LeetCode.
 */
public class FlattenNestedListIteratorLeetCode {



    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

    /*
    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack;
        int returnVal=0;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for(int i=nestedList.size()-1;i>=0;i--) stack.push(nestedList.get(i));
        }

        @Override
        public Integer next() {
            return returnVal;
        }

        @Override
        public boolean hasNext() {
            if(stack.isEmpty()) return false;
            NestedInteger cur = stack.pop();
            while(!cur.isInteger()){
                List<NestedInteger> list = cur.getList();
                for(int i=list.size()-1;i>=0;i--) stack.push(list.get(i));
                if(stack.isEmpty()) return false;
                cur=stack.pop();
            }
            returnVal=cur.getInteger();
            return true;
        }
    }
    */

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */



}
