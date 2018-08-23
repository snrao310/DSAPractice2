/**
 *
 *Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 */

public class Search2DMatrixIILeetCode {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        return searchMatrix(matrix,target,0,0,matrix.length-1,matrix[0].length-1);
    }

    //Recursion eliminates 1/4 of the array every time. O(log N) where N is number of elements. Or O(log m*n) where m is
    //number of rows and n is number of columns. Same as O(logm + logn).
    private static boolean searchMatrix(int[][] matrix, int target, int rowStart, int colStart, int rowEnd, int colEnd){
        if(rowEnd<rowStart || colEnd<colStart) return false;
        if((rowEnd-rowStart+1)*(colEnd-colStart+1)<=4)
            return manualSearch(matrix,target,rowStart,colStart,rowEnd,colEnd);
        int midRow = rowStart + (rowEnd-rowStart)/2;
        int midCol = colStart + (colEnd-colStart)/2;
        int midVal = matrix[midRow][midCol];
        if(midVal==target) return true;
        if(midVal>target){
            return searchMatrix(matrix,target,rowStart,colStart,midRow-1,midCol-1) ||
                    searchMatrix(matrix,target,midRow,colStart,rowEnd,midCol-1) ||
                    searchMatrix(matrix,target,rowStart,midCol,midRow-1,colEnd);
        }
        else{
            return searchMatrix(matrix,target,rowStart,midCol+1,midRow-1,colEnd) ||
                    searchMatrix(matrix,target,midRow+1,colStart,rowEnd,midCol-1) ||
                    searchMatrix(matrix,target,midRow,midCol,rowEnd,colEnd);
        }
    }

    private static boolean manualSearch(int[][] matrix, int target, int startRow, int startCol, int endRow, int endCol){
       for(int i=startRow;i<=endRow;i++)
           for(int j=startCol;j<=endCol;j++)
               if(matrix[i][j]==target)
                   return true;
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
