import java.util.Arrays;

/**
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroesLeetCode {

    //Can do it in O(m+n) space also (better than naive O(n^2) space), but this is just brilliant.
    // Only key challenge is when either first row or first column has a 0, matrix[0][0] is set.
    // So for either first row or first column, calculation should be done separately.
    public static void setZeroes(int[][] matrix) {
        if(matrix.length==0) return;
        int m=matrix.length, n=matrix[0].length;
        boolean isRowZero=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    if(i!=0) matrix[i][0]=0;
                    else isRowZero=true;
                }
            }
        }

        for(int i=1;i<m;i++)
            if(matrix[i][0]==0)
                Arrays.fill(matrix[i],0);

        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                for(int j=0;j<m;j++) matrix[j][i]=0;
            }
        }

        if(isRowZero) Arrays.fill(matrix[0],0);
    }

    public static void main(String args[]) {
        int[][] mat = {{1,2,3,4},{5,0,5,2},{1,1,1,4},{1,2,1,3},{1,1,1,1}};
        setZeroes(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}
