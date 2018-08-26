import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed
 * as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to
 * finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses,
 * return an empty array.
 *
 */
public class CourseScheduleIILeetCode {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++)
            graph.put(i,new HashSet<>());
        for(int i=0;i<prerequisites.length;i++)
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        return topologicalSort(graph);
    }

    private static int[] topologicalSort(HashMap<Integer,HashSet<Integer>> graph){
        int n= graph.size();
        int[] result = new int[n];
        boolean[] visited = new boolean[n], detectCycle = new boolean[n];
        for(int i: graph.keySet()){
            if(!visited[i])
                n=DFS(graph,visited,detectCycle,result,i,n);
            if(n==-1)
                return new int[]{};
        }
        return result;
    }

    private static int DFS(HashMap<Integer,HashSet<Integer>> graph, boolean[] visited, boolean[] detectCycle,
                    int[] result,int start, int ind){
        if(detectCycle[start]) return -1;
        if(visited[start]) return ind;

        visited[start]=true; detectCycle[start]=true;
        for(int neighbor: graph.get(start)){
            ind = DFS(graph,visited,detectCycle,result,neighbor,ind);
            if(ind==-1) return -1;
        }
        result[--ind]=start;
        detectCycle[start]=false;
        return ind;
    }


    public static void main(String args[]){
        int[] res=findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}});
        for(int i:res)
            System.out.print(i+" ");
    }
}
