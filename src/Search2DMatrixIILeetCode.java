/**
 * Created by snrao on 12/21/16.
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following
 * properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 */

public class Search2DMatrixIILeetCode {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        return searchMatrix(matrix,target,0,0,matrix.length-1,matrix[0].length-1);
    }

    //Recursion eliminates 1/4 of the array every time. O(log N) where N is number of elements. Or O(log m*n) where m is
    //number of rows and n is number of columns. Same as O(logm + logn).
    private static boolean searchMatrix(int[][] matrix, int target, int startRow, int startCol, int endRow, int endCol) {
        int rows = endRow-startRow+1, cols= endCol-startCol+1;
        if(rows*cols <=4 ) return manualSearch(matrix,target,startRow,startCol,endRow,endCol);

        int midRow = startRow + rows/2, midCol = startCol + cols/2;
        int pivot = matrix[midRow][midCol];
        if(pivot<target){
            return searchMatrix(matrix,target,midRow,midCol,endRow,endCol) ||
                    searchMatrix(matrix,target,midRow,startCol,endRow,midCol) ||
                    searchMatrix(matrix,target,startRow,midCol,midRow,endCol);
        }
        else{
            return searchMatrix(matrix,target,startRow,startCol,midRow,midCol) ||
                    searchMatrix(matrix,target,midRow,startCol,endRow,midCol) ||
                    searchMatrix(matrix,target,startRow,midCol,midRow,endCol);
        }
    }

    private static boolean manualSearch(int[][] matrix, int target, int startRow, int startCol, int endRow, int endCol){
        for(int i=startRow;i<=endRow;i++){
            for(int j=startCol;j<=endCol;j++){
                if(matrix[i][j]==target)
                    return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(searchMatrix(new int[][]
                {{1,  4,  7, 11, 15},
                        {2,   5,  8, 12, 19},
                        {3,   6,  9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}},18));
        System.out.println(searchMatrix(new int[][]{{}},0));
    }
}
