/**
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following
 * properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 */
public class Search2DMatrixLeetCode {

    //2d binary search. For MxN matrix, complexity is O(logM+logN).
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;
        int m=matrix.length, n=matrix[0].length;
        int l=0,h=m-1,mid=0;
        while(l<=h){
            mid=(l+h)/2;
            if(matrix[mid][0]==target || matrix[mid][n-1]==target) return true;
            if(matrix[mid][0]<target && matrix[mid][n-1]>target) break;
            else if(matrix[mid][0]<target) l=mid+1;
            else h=mid-1;
        }
        if(!(matrix[mid][0]<target && matrix[mid][n-1]>target)) return false;
        l=0; h=n-1;
        int row=mid;
        while(l<=h){
            mid=(l+h)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]<target) l=mid+1;
            else h=mid-1;
        }
        return false;
    }


    public static void main(String args[]){
        System.out.println(searchMatrix(new int[][]{{1,3,5,7}, {10,1,16,20},{23,30,34,50}},3));
        System.out.println(searchMatrix(new int[][]{{1}},0));
    }
}

