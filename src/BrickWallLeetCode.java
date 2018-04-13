import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 *
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the
 * same height but different width. You want to draw a vertical line from the top to the bottom and cross the least
 * bricks.
 *
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick
 * in this row from left to right.
 *
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to
 * draw the line to cross the least bricks and return the number of crossed bricks.
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously
 * cross no bricks.
 *
 * Example:
 * Input:
 * [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * Output: 2
 *
 * Note:
 * The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of
 * bricks of the wall won't exceed 20,000.
 *
 */
public class BrickWallLeetCode {

    public static int leastBricks(List<List<Integer>> wall) {
        int maxEdges=0, height=wall.size();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(List<Integer> row: wall){
            int position=0;
            for(int i: row){
                position+=i;
                map.put(position,map.getOrDefault(position,0)+1);
            }
            map.remove(position);
        }
        for(int key:map.keySet())
            maxEdges=Math.max(maxEdges,map.get(key));
        return height-maxEdges;
    }

    public static void main(String args[]){
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));
        System.out.println(leastBricks(wall));
    }
}
