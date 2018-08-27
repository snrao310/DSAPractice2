import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 *
 */
public class CloneGraphLeetCode {

    //      Definition for undirected graph.
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if(node==null) return null;
            return DFS(node,new HashMap<Integer,UndirectedGraphNode>());
        }

        private UndirectedGraphNode DFS(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> oldToNew){
            if(oldToNew.containsKey(node.label)) return oldToNew.get(node.label);
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            oldToNew.put(node.label, clone);
            for(UndirectedGraphNode neighbor: node.neighbors){
                UndirectedGraphNode neighborClone = DFS(neighbor, oldToNew);
                clone.neighbors.add(neighborClone);
            }
            return clone;
        }
    }
}
