import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular array (the next element of the last element is the first element of the array), print the Next
 * Greater Number for every element. The Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly to find its next greater number. If it
 * doesn't exist, output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 *
 * Note: The length of given array won't exceed 10000.
 */
public class NextGreaterElementIILeetCode {

    public static int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) return nums;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.peek()] = nums[i];
                stack.pop();
            }
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 6, 2, 1, 5, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 1, 1})));
    }

}
