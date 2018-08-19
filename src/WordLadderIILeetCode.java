import java.util.*;

/**
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
 * from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 *
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code
 * definition to get the latest changes.
 *
 */
public class WordLadderIILeetCode {

    //The basic idea is:
    // 1). Use BFS to find the shortest distance between start and end, tracing the number of steps (nodes of graph)
    // from start node to end node, and store each node's next level neighbors in HashMap. The key idea is to store only
    // the next level neighbors for DFS traversal (next step in the algorithm), and ignore all other neighbors. I did
    // this by maintaining another HashSet while doing BFS in addition to the general visited HashSet called
    // nextLevelNeighbors. When we see an unvisited neighbor node during BFS, we add it to visited, we add it to queue,
    // we add it to the nextLevelNeighbors and we add it to the dfs-neighbors map. When we see a visited node, we check
    // if it was added to visited during this level itself ie. if it exists in the nextLevelNeighbors HashSet. If it
    // exists, we add it to dfs-neighbors map. Every time a level is completed, we clear the nextLevelNeighbors HashSet.
    //
    // 2). Use DFS with backtracking to traverse all paths with the same distance (number of steps/nodes obtained from
    // BFS) and add the path to the list if it leads to the end node (endWord).
    //
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        HashSet<String> dict = new HashSet<>();
        HashMap<String,HashSet<String>> dfsNeighbors = new HashMap<>();
        for(String word: wordList) dict.add(word);
        if(!dict.contains(endWord)) return result;
        int steps = BFS(beginWord, endWord, dict, dfsNeighbors);
        List<String> tempList = new ArrayList<>();
        tempList.add(beginWord);
        backtrackFunction(beginWord, endWord, dfsNeighbors, dict, 1, steps, tempList, result);
        return result;
    }

    private static int BFS(String beginWord, String endWord, HashSet<String> dict, HashMap<String,HashSet<String>> neighbors){
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>(), nextLevelNodes= new HashSet<>();
        queue.offer(beginWord); queue.offer(null); visited.add(beginWord);
        int steps = 1;
        boolean found = false;
        while(!queue.isEmpty()){
            String cur = queue.poll();
            neighbors.put(cur, new HashSet());
            if(cur!=null){
                char[] curStr=cur.toCharArray();
                for(int i=0;i<curStr.length;i++){
                    for(char c='a';c<='z';c++){
                        if(curStr[i]==c) continue;
                        char temp = curStr[i]; curStr[i]=c;
                        String nextWord = new String(curStr);
                        if(nextWord.equals(endWord)){
                            found = true;
                        }
                        if(dict.contains(nextWord)){
                            if(!visited.contains(nextWord)){
                                nextLevelNodes.add(nextWord);
                                neighbors.get(cur).add(nextWord);
                                queue.offer(nextWord);
                                visited.add(nextWord);
                            }
                            else if(nextLevelNodes.contains(nextWord))
                                neighbors.get(cur).add(nextWord);
                        }
                        curStr[i]=temp;
                    }
                }
            }
            else{
                steps++;
                nextLevelNodes.clear();
                if(!queue.isEmpty())
                    queue.offer(null);
                if(found)
                    return steps;
            }
        }
        return steps;
    }

    private static void backtrackFunction(String beginWord, String endWord, HashMap<String,HashSet<String>> neighbors,
                                   HashSet<String> dict, int steps, int maxSteps, List<String> tempList,
                                   List<List<String>> result){
        if(steps==maxSteps) return;
        if(neighbors.get(beginWord)==null) return;
        for(String nextWord: neighbors.get(beginWord)){
            if(nextWord.equals(endWord)){
                List<String> finalList = new ArrayList<>(tempList);
                finalList.add(endWord);
                result.add(finalList);
                return;
            }
            if(dict.contains(nextWord)){
                tempList.add(nextWord);
                backtrackFunction(nextWord,endWord,neighbors,dict,steps+1,maxSteps,tempList,result);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String args[]){
        List<String> wordList=new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        List<List<String>> list=findLadders("hit","cog",wordList);
        for(List<String> l:list)
            System.out.println(l);
    }
}
