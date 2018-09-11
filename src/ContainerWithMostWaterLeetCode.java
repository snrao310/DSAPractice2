/**
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most water.
 */

public class ContainerWithMostWaterLeetCode {

    public static int maxArea(int[] height) {
        int l=0,r=height.length-1, maxArea=0;
        while(l<r){
            int h=Math.min(height[l],height[r]);
            int w=r-l;
            maxArea=Math.max(maxArea,w*h);
            if(height[l]<=height[r]) l++;
            else r--;
        }
        return maxArea;
    }

    public static void main(String args[]){
        System.out.println(maxArea(new int[]{1,4,5,1}));
    }

}
