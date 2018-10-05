/*
Implement an iterator to flatten a 2d vector.

Example:

Input: 2d vector =
[
  [1,2],
  [3],
  [4,5,6]
]
Output: [1,2,3,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,2,3,4,5,6].
Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Flatten2DVectorLeetCode {

    public static class Vector2D implements Iterator<Integer> {

        int curRow, curCol, numRows;
        List<List<Integer>> vec;

        public Vector2D(List<List<Integer>> vec2d) {
            numRows=vec2d.size();
            curRow=0; curCol=0;
            vec=vec2d;
        }

        @Override
        public Integer next() {
            return vec.get(curRow).get(curCol++);
        }

        @Override
        public boolean hasNext() {
            while(curRow<numRows){
                List<Integer> row = vec.get(curRow);
                if(curCol<row.size()) return true;
                else{
                    curRow++;curCol=0;
                }
            }
            return false;
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
    public static void main(String args[]){
        List<Integer> l1=new ArrayList<>(Arrays.asList(1,2));
        List<Integer> l2=new ArrayList<>(Arrays.asList(3));
        List<Integer> l3=new ArrayList<>(Arrays.asList(4,5,6));
        List<List<Integer>> l=new ArrayList<>(Arrays.asList(l1,l2,l3));
        Vector2D i=new Vector2D(l);
        while (i.hasNext()) System.out.println(i.next());
    }
}
