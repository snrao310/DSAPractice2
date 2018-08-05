/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */

public class RotateImageLeetCode {

    public static void rotate(int[][] matrix) {
        if(matrix.length == 0) return;
        int minRow = 0, maxRow = matrix.length -1, minCol = 0, maxCol = matrix.length -1;
        while(maxRow > minRow){
            for(int i=0; i< (maxRow - minRow); i++){
                int temp1 = matrix[minRow][minCol+i];
                int temp2 = matrix[minRow+i][maxCol];
                int temp3 = matrix[maxRow][maxCol-i];
                int temp4 = matrix[maxRow-i][minCol];
                matrix[minRow][minCol+i] = temp4;
                matrix[minRow+i][maxCol] = temp1;
                matrix[maxRow][maxCol-i] = temp2;
                matrix[maxRow-i][minCol] = temp3;
            }
            minRow++; maxRow--; minCol++; maxCol--;
        }
    }

    public static void main(String args[]){
        int mat[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(mat);
        for(int[] m: mat){
            for(int i: m)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
