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
        int done = 0, n = matrix.length*matrix[0].length, dir = 1;
        int rowMin = 0, rowMax = matrix.length-1, colMin = 0, colMax = matrix[0].length-1;
        int rowStart = rowMin, rowEnd = rowMax, colStart = colMin, colEnd = colMax;
        while(done!=n){
            for(int i=colStart; i!=colEnd; i+=dir){
                result.add(matrix[rowStart][i]);
                if(++done==n) break;
            }
            for(int i=rowStart; i!=rowEnd; i+=dir){
                result.add(matrix[i][colEnd]);
                if(++done==n) break;
            }
            if(rowEnd==rowStart) {
                result.add(matrix[rowStart][colEnd]);
                if(++done==n) break;
            }
            if(dir==-1){
                rowMin++; rowMax--;
                colMin++; colMax--;
                rowStart = rowMin; rowEnd = rowMax; colStart = colMin; colEnd = colMax;
            }
            else{
                rowStart = rowMax; rowEnd = rowMin; colStart = colMax; colEnd = colMin;
            }
            dir*=(-1);
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(spiralOrder(new int[][]{{1}}));
        System.out.println(spiralOrder(new int[][]{{1}, {2}, {3}}));
    }
}
