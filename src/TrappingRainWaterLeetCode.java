import java.util.Arrays;
import java.util.Stack;

/**
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 *
 */
public class TrappingRainWaterLeetCode {

    public static int trap(int[] height) {
        if(height.length==0) return 0;
        int[] nextGreater = new int[height.length], nextMax = new int[height.length];
        getNextGreater(height, nextGreater);
        getNextMax(height, nextMax);
        int result=0;
        for(int i=0;i<height.length;i++){
            if(height[i]==0) continue;
            int nextIndex=(nextGreater[i]==-1)?nextMax[i]:nextGreater[i];
            if(nextIndex==-1) continue;
            int areaWidth=(nextIndex-i-1), areaHeight = Math.min(height[nextIndex], height[i]);
            int area = areaHeight * areaWidth;
            while(i+1<nextIndex){
                area-=height[i+1];
                i++;
            }
            result+=area;
        }
        return result;
    }

    private static void getNextGreater(int[] height, int[] nextGreater){
        Arrays.fill(nextGreater,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && height[stack.peek()]<height[i]){
                nextGreater[stack.pop()]=i;
            }
            stack.push(i);
        }
    }

    private static void getNextMax(int[] height, int[] nextMax) {
        int curMaxIndex = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            nextMax[i] = curMaxIndex;
            if (curMaxIndex == -1 || height[i] >= height[curMaxIndex]) {
                curMaxIndex = i;
            }
        }
    }

    public static void main(String args[]){
        System.out.print(trap(new int[]{2,0,2}));
    }
}
