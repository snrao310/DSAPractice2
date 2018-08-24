import java.util.Arrays;

/**
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 *
 */
public class MedianOfTwoSortedArraysLeetCode {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
            return findMedianSortedArrays(nums2,nums1,0,nums2.length-1,0,nums1.length-1);
        return findMedianSortedArrays(nums1,nums2,0,nums1.length-1,0,nums2.length-1);
    }

    //Same algorithm as median of two sorted arrays of same length.
    //But due to different lengths, we reduce each array by half the length of smaller array each time. Base cases are the real challenge.
    //Note that if halves of the array on each side of mid are of different size, we reduce by the smaller half's length
    //even if elimination is in the bigger half's side. This will ensure the median is still in the remaining part of the array.
    //Complexity is O(log(min(m,n)))
    public static double findMedianSortedArrays(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2){
        int len1 = end1-start1+1, len2 = end2-start2+1;
        int mid1 = start1+(len1-1)/2, mid2 = start2+(len2-1)/2;
        int numEliminated = mid2-start2;
        if(len2==0)
            return getMedian(nums1, start1,end1);
        if(len2==1)
            return getMedian(nums1,start1, end1, nums2[start2]);
        if(len2==2)
            return getMedian(nums1,start1,end1,nums2[start2],nums2[end2]);
        if(nums1[mid1]>nums2[mid2])
            return findMedianSortedArrays(nums1,nums2,start1,end1-numEliminated,mid2,end2);
        else
            return findMedianSortedArrays(nums1,nums2,start1+numEliminated,end1,start2,end2-numEliminated);
    }

    //Following are the base case functions

    //median of 3 numbers
    private static double getMedian(int x,int y, int z){
        int[] arr = new int[]{x,y,z};
        Arrays.sort(arr);
        return arr[1];
    }

    //median of 4 numbers
    private static double getMedian(int w, int x,int y, int z){
        int[] arr = new int[]{w,x,y,z};
        Arrays.sort(arr);
        return (arr[1]+arr[2])/2.0;
    }

    //median of a sorted array (when len2=0). 2 cases: len1 is odd, len1 is even.
    private static double getMedian(int[] nums,int start,int end){
        int len = end-start+1, mid = start + len/2;
        if(len%2!=0)
            return nums[mid];
        else
            return (nums[mid]+nums[mid-1])/2.0;
    }


    //median of a sorted array and one number (when len2=1). 3 cases: len1 is 1. len1 is odd, len1 is even.
    private static double getMedian(int[] nums, int start, int end, int x){
        int len = end-start+1, mid = start+ len/2;
        if(len==1)
            return (nums[start]+x)/2.0;
        if(len%2!=0)
            return getMedian(nums[mid],nums[mid-1],nums[mid+1],x);
        else
            return getMedian(nums[mid],nums[mid-1],x);
    }

    //median of a sorted array and 2 numbers (when len2=2). x and y have to be sorted (x<y). 3 cases: len1 is 2. len1 is odd. len1 is even.
    private static double getMedian(int[] nums, int start, int end, int x, int y){
        int len = end-start+1, mid = start+ len/2;
        if(len==2)
            return getMedian(x,y,nums[start],nums[end]);
        if(len%2!=0)
            return getMedian(nums[mid],Math.max(nums[mid-1],x),Math.min(nums[mid+1],y));
        else
            return getMedian(nums[mid],nums[mid-1],Math.max(x,nums[mid-2]),Math.min(y,nums[mid+1]));
    }

    public static void main(String args[]){
        System.out.print(findMedianSortedArrays(new int[]{1,2,3},new int[]{4,5,6}));
    }
}