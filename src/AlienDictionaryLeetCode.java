import java.util.HashMap;
import java.util.HashSet;

/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
]

Output: ""

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 */

class AlienDictionaryLeetCode {

    private static class GraphNode{
        char val;
        HashSet<GraphNode> next;
        GraphNode(char c){
            val = c;
            next = new HashSet<>();
        }
    }

    public static String alienOrder(String[] words) {

        HashMap<Character, GraphNode> graph = new HashMap<>();

        for(int i=0;i<words.length;i++){
            int j=0;
            if(i!=0){
                while(j<words[i-1].length() && words[i].charAt(j)==words[i-1].charAt(j))
                    j++;
                if(j!=words[i-1].length()){
                    char prevWordChar = words[i-1].charAt(j);
                    char nextWordChar = words[i].charAt(j);
                    GraphNode prevNode = graph.get(prevWordChar);
                    GraphNode curNode= (graph.containsKey(nextWordChar))?graph.get(nextWordChar): new GraphNode(nextWordChar);
                    graph.put(nextWordChar,curNode);
                    prevNode.next.add(curNode);
                    j++;
                }
            }
            while(j<words[i].length()){
                if(!graph.containsKey(words[i].charAt(j)))
                    graph.put(words[i].charAt(j),new GraphNode(words[i].charAt(j)));
                j++;
            }
        }

        String res = topologicalSort(graph);
        return res;
    }


    private static String topologicalSort(HashMap<Character,GraphNode> graph){
        char[] res=new char[graph.size()];
        int curIndex= graph.size()-1;
        HashSet<GraphNode> visited = new HashSet<>(), cycleDetect = new HashSet<>();
        for(Character node: graph.keySet()){
            if(!visited.contains(graph.get(node))){
                curIndex = DFS(graph, graph.get(node), res, visited, cycleDetect, curIndex);
                if(curIndex==Integer.MIN_VALUE)
                    return "";
            }
        }
        return new String(res);
    }

    private static int DFS(HashMap<Character,GraphNode> graph, GraphNode node, char[] res, HashSet<GraphNode> visited,
                           HashSet<GraphNode> cycleDetect, int curIndex){
        visited.add(node);
        cycleDetect.add(node);
        HashSet<GraphNode> neighbors = node.next;
        for(GraphNode neighbor: neighbors){
            if(cycleDetect.contains(neighbor)){
                return Integer.MIN_VALUE;
            }
            if(!visited.contains(neighbor)){
                curIndex = DFS(graph, neighbor, res, visited, cycleDetect, curIndex);
                if(curIndex==Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        res[curIndex--] = node.val;
        cycleDetect.remove(node);
        return curIndex;
    }

    public static void main(String args[]){
        System.out.println(alienOrder(new String[]{"c","c"}));
    }
}