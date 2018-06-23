import java.util.*;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree.
 * Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a
 * function to find all the MHTs and return a list of their root labels.
 */
public class MinimumHeightTreesLeetCode {

    //The basic idea is "keep deleting leaves layer-by-layer, until reach the root." Specifically, first find all the leaves,
    // then remove them. After removing, some nodes will become new leaves. So we can continue remove them. Eventually, there
    // is only 1 or 2 nodes left. If there is only one node left, it is the root. If there are 2 nodes, either of them could be
    // a possible root. Time Complexity: Since each node will be removed at most once, the complexity is O(n).
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(edges.length==0){
            result.add(0);
            return result;
        }
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) graph.put(edge[0], new HashSet<>());
            if (!graph.containsKey(edge[1])) graph.put(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int visited = 0;
        for (int i : graph.keySet()) {
            if (graph.get(i).size() == 1) {
                visited++;
                queue.offer(i);
            }
        }
        queue.offer(null);

        while (visited != n) {
            while (queue.peek() != null) {
                Integer node = queue.poll();
                HashSet<Integer> neighbors = graph.get(node);
                for (int i : neighbors) {
                    graph.get(i).remove(node);
                    if (graph.get(i).size() == 1) {
                        visited++;
                        queue.offer(i);
                    }
                }
            }
            queue.poll();
            if(!queue.isEmpty())
                queue.offer(null);
        }

        while (!queue.isEmpty()) {
            if (queue.peek() != null)
                result.add(queue.peek());
            queue.poll();
        }

        return result;
    }

    public static void main(String args[]) {
        List<Integer> list = findMinHeightTrees(1, new int[][]{});
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}