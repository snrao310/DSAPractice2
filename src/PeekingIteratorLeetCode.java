import java.util.Iterator;

/**
 *
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator
 * that support the peek() operation -- it essentially peek() at the element that will be returned by the next
 * call to next().
 *
 */
public class PeekingIteratorLeetCode {
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.htm
    class PeekingIterator implements Iterator<Integer> {

        Integer nextOne;
        Iterator<Integer> iterator;


        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            nextOne = iterator.next();
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nextOne;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer returnValue=nextOne;
            if(iterator.hasNext())
                nextOne=iterator.next();
            else nextOne=null;
            return returnValue;
        }

        @Override
        public boolean hasNext() {
            return (nextOne!=null);
        }
    }
}
