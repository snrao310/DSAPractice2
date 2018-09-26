/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if they have the same shape, or have the same shape after rotation (90, 180, or 270 degrees only) or reflection (left/right direction or up/down direction).

Example 1:
11000
10000
00001
00011
Given the above grid map, return 1.

Notice that:
11
1
and
 1
11
are considered same island shapes. Because if we make a 180 degrees clockwise rotation on the first island, then two islands will have the same shapes.
Example 2:
11100
10001
01001
01110
Given the above grid map, return 2.

Here are the two distinct islands:
111
1
and
1
1

Notice that:
111
1
and
1
111
are considered same island shapes. Because if we flip the first array in the up/down direction, then they have the same shapes.
Note: The length of each dimension in the given grid does not exceed 50.
 */

import java.util.Arrays;
import java.util.HashSet;

public class NumberOfDistictIslandsIILeetCode {

    private static int[][] dirs= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public static int numDistinctIslands2(int[][] grid) {
        if(grid.length==0) return 0;
        int result = 0, m=grid.length, n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        HashSet<String> shapeSet = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    HashSet<int[]> island = new HashSet<>();
                    dfs(grid,i,j,visited, island);
                    String shape = getShape(island,n);
                    if(!shapeSet.contains(shape)){
                        shapeSet.add(shape);
                        result++;
                    }
                }
            }
        }
        return result;
    }


    //this is the real challenge in this question. Need to consider all 8 combinations. All combinations of reflection and rotations.
    //x,y   x,-y    -x,y    -x,-y   y,x     y,-x    -y,x    -y,-x
    //and then create a string from all of them and sort and maintain in hashmap.
    private static String getShape(HashSet<int[]> island, int width){
        int len=island.size();
        int[] xvals=new int[len], yvals=new int[len], svals=new int[len];
        String[] sArrays=new String[8];
        for(int i=0;i<8;i++){
            int t=0, xmin=Integer.MAX_VALUE, ymin=Integer.MAX_VALUE;;
            for(int[] cell: island){
                xvals[t]=(i<4)?(i<2)?cell[0]:-cell[0]:(i<6)?cell[1]:-cell[1];
                yvals[t]=(i<4)?(i%2==0)?cell[1]:-cell[1]:(i%2==0)?cell[0]:-cell[0];
                xmin=Math.min(xmin, xvals[t]);
                ymin=Math.min(ymin, yvals[t]);
                t++;
            }
            for(int j=0;j<len;j++){
                xvals[j]-=xmin; yvals[j]-=ymin;
            }
            for(int j=0;j<len;j++){
                svals[j]=xvals[j]*width+yvals[j];
            }
            Arrays.sort(svals);
            sArrays[i]=Arrays.toString(svals);
        }
        Arrays.sort(sArrays);
        return Arrays.toString(sArrays);
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] visited, HashSet<int[]> island) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] || grid[i][j]==0) return;
        visited[i][j]=true;
        island.add(new int[]{i,j});
        for(int[] dir: dirs){
            dfs(grid, i+dir[0], j+dir[1], visited, island);
        }
    }


    public static void main(String args[]){
        System.out.println(numDistinctIslands2(new int[][]{{1,1,0,0,0},{1,0,0,0,0},{0,0,0,0,1},{0,0,0,1,1}}));
    }
}
