import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrixLeetCode {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0) return result;
        int height= matrix.length, width = matrix[0].length;
        int colStart = 0, colEnd = width - 1, rowStart = 0, rowEnd = height - 1, visited = 0, totalElements = height * width, flag = 1;
        while (visited != totalElements) {
            for (int i = colStart; i != colEnd; i += flag) {
                result.add(matrix[rowStart][i]);
                if (++visited == totalElements) return result;
            }
            for (int i = rowStart; i != rowEnd; i += flag) {
                result.add(matrix[i][colEnd]);
                if (++visited == totalElements) return result;
            }
            int temp=colStart;
            colStart=colEnd;
            colEnd=temp;

            temp=rowStart;
            rowStart=rowEnd;
            rowEnd=temp;

            flag *= -1;
            if(flag==1){
                rowStart++;rowEnd--; colStart++;colEnd--;
            }
            if(rowStart==rowEnd && colStart==colEnd) {
                result.add(matrix[rowEnd][colEnd]);
                if(++visited==totalElements)
                    return result;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(spiralOrder(new int[][]{{1}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
