import java.util.Arrays;
import java.util.Stack;

/**
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 *
 */
public class LargestRectangleInHistogramLeetCode {


    //general algorithm to find the next rectangle to the right shorter than each element of array.
    //When you find the next rectangle shorter than current top of stack (lets call it r), the
    //next element in the stack below the top of the stack will be the first element on the left shorter than
    //top of the stack (lets call it l). The max area rectangle containing the top of the stack then is
    //(r to l)*(height of top of stack).
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea=0;
        for(int i=0;i<=heights.length;i++){
            while(stack.peek()!=-1 && (i==heights.length || heights[stack.peek()]>heights[i])){
                int height = heights[stack.pop()];
                int width = (i-1)-stack.peek();
                int area = height*width;
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String args[]){
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
