/**
 * Created by snrao on 12/21/16.
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most water.
 */

public class ContainerWithMostWaterLeetCode {

    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;

        while(left<right){
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String args[]){
        System.out.println(maxArea(new int[]{1,4,5,1}));
    }

}
