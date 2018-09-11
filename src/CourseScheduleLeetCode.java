import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all
 * courses?
 *
 */
public class CourseScheduleLeetCode {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,HashSet<Integer>> graph = constructGraph(prerequisites);
        return !hasCycle(graph);
    }

    private static HashMap constructGraph(int[][] prereqs){
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
        for(int i=0;i<prereqs.length;i++){
            if(!graph.containsKey(prereqs[i][0]))
                graph.put(prereqs[i][0],new HashSet<>());
            graph.get(prereqs[i][0]).add(prereqs[i][1]);
        }
        return graph;
    }

    private static boolean hasCycle(HashMap<Integer,HashSet<Integer>> graph){
        HashSet<Integer> visited = new HashSet<>();
        for(int i: graph.keySet()){
            if(!visited.contains(i))
                if(DfsDetectCycle(graph,i,visited,new HashSet<>()))
                    return true;
        }
        return false;
    }

    private static boolean DfsDetectCycle(HashMap<Integer,HashSet<Integer>> graph, int source,
                                   HashSet<Integer> visited, HashSet<Integer> detectCycle){
        if(detectCycle.contains(source)) return true;
        if(visited.contains(source)) return false;
        detectCycle.add(source);
        visited.add(source);
        if(graph.get(source)!=null){
            for(int i: graph.get(source)){
                if(DfsDetectCycle(graph,i,visited,detectCycle))
                    return true;
            }
        }
        detectCycle.remove(source);
        return false;
    }

    public static void main(String args[]){
        System.out.println(canFinish(2,new int[][]{{1,0}}));
        System.out.println(canFinish(2,new int[][]{{1,0},{0,1}}));
    }
}
