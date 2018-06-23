import java.util.HashSet;

/**
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 *
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 *
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 *
 */
public class NumberOfIslandsLeetCode {


    static int[][] dirns = {{0,1},{0,-1},{1,0},{-1,0}};

    public static int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int m=grid.length, n=grid[0].length, numIslands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='0' || visited[i][j]) continue;
                DFS(grid,visited,i,j);
                numIslands++;
            }
        }
        return numIslands;
    }

    private static void DFS(char[][] grid, boolean[][] visited,int i, int j){
        if(i<0 || i==grid.length || j<0 || j==grid[0].length || visited[i][j] || grid[i][j]=='0')
            return;

        visited[i][j] = true;
        for(int[] d: dirns){
            int inext= i + d[0], jnext = j+d[1];
            DFS(grid,visited,inext,jnext);
        }
    }

    public static void main(String args[]){
        char[][] grid=new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
}
