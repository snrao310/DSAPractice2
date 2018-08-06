/*
You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:
Input:
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
Example 2:
Input:
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
Example 3:
Input:
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
Hint: size of the given matrix will not exceed 50x50.
 */

import java.util.*;

public class CutOffTreesForGolfEventLeetCode {

    static int[][] dirns = {{0,1},{1,0},{0,-1},{-1,0}};

    public static int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        if(forest.size()==0) return -1;
        int m= forest.size(), n = forest.get(0).size(), i=0,j=0, result=0;
        int[][] map = new int[m][n];
        for(List<Integer> list: forest){
            for(int num: list){
                map[i][j] = num;
                if(num>1)
                    heap.offer(new int[]{num, i, j});
                j++;
            }
            i++;j=0;
        }

        int startX=0, startY=0;
        while(!heap.isEmpty()){
            int[] element = heap.poll();
            int steps=BFS(startX, startY, element[1],element[2],map);
            if(steps==-1) return steps;
            result+=steps;
            startX=element[1]; startY=element[2];
            map[startX][startY]=1;
        }
        return result;
    }

    private static int BFS(int startX, int startY, int endX, int endY, int[][] map){
        if(startX==endX && startY==endY) return 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        queue.offer(new int[]{startX,startY});
        queue.offer(null);
        visited[startX][startY]=true;
        int steps = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur!=null){
                for(int[] dirn: dirns){
                    int nextX = cur[0]+dirn[0];
                    int nextY = cur[1]+dirn[1];
                    if(nextX==endX && nextY==endY)
                        return steps;
                    if(nextX>=0 && nextX<map.length && nextY>=0 && nextY<map[0].length &&
                            map[nextX][nextY]!=0 && !visited[nextX][nextY]){
                        queue.offer(new int[]{nextX,nextY});
                        visited[nextX][nextY]=true;
                    }
                }
            }
            else{
                if(!queue.isEmpty())
                    queue.offer(null);
                steps++;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(0,0,4);
        List<Integer> list3 = Arrays.asList(7,6,5);
        List<List<Integer>> input = Arrays.asList(list1, list2, list3);
        System.out.println(cutOffTree(input));
    }
}
