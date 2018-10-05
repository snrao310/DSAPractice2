import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the
 * "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and
 * bottom edges.
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal
 * or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 */
public class PacificAtlanticWaterFlowLeetCode {

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result=new ArrayList<>();
        if(matrix.length==0)return result;
        int m=matrix.length, n=matrix[0].length;
        boolean[][] atlantic=new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        for(int i=0;i<m;i++){
            DFS(matrix,i,0,Integer.MIN_VALUE,pacific);
            DFS(matrix,i,n-1,Integer.MIN_VALUE,atlantic);
        }
        for(int i=0;i<n;i++){
            DFS(matrix,0,i,Integer.MIN_VALUE,pacific);
            DFS(matrix,m-1,i,Integer.MIN_VALUE,atlantic);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atlantic[i][j] && pacific[i][j])
                    result.add(new int[]{i,j});
            }
        }
        return result;
    }

    private static int[][] dirs= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    private static void DFS(int[][] matrix,int i,int j,int height,boolean[][] visited){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || visited[i][j] || height>matrix[i][j]) return;

        visited[i][j]=true;
        for(int[] dir: dirs)
            DFS(matrix,i+dir[0],j+dir[1],matrix[i][j],visited);
    }

    //This is how BFS graph search is done for matrices.
    private static void BFS(int[][] matrix, boolean[][] visited,int i,int j){
        Queue<int[]> queue=new LinkedList();
        visited[i][j]=true;
        queue.offer(new int[]{i,j});
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] d:dir){
                i=cur[0]+d[0];
                j=cur[1]+d[1];
                if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || visited[i][j] || matrix[i][j]<matrix[cur[0]][cur[1]])
                    continue;
                visited[i][j]=true;
                queue.offer(new int[]{i,j});
            }
        }
    }

    public static void main(String args[]) {
        int[][] matrix = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<int[]> list = pacificAtlantic(matrix);
        for (int[] a : list) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
