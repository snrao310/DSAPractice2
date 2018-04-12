import java.util.*;

/**
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
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

public class WordLadderLeetCode {


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 0;
        HashSet<String> wordSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for(String s:wordList)
            wordSet.add(s);
        if(!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord); queue.offer(null);
        int steps=1;

        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(cur!=null){
                for(int i=0;i<cur.length();i++){
                    char[] word=cur.toCharArray();
                    for(char c='a';c<='z';c++){
                        word[i]=c;
                        String nextWord=String.valueOf(word);
                        if(nextWord.equals(endWord))
                            return steps+1;
                        if(wordSet.contains(nextWord) && !visited.contains(nextWord)){
                            queue.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }
            else{
                if(!queue.isEmpty())
                    queue.offer(null);
                steps++;
            }
        }
        return 0;
    }

    public static void main(String args[]){
        System.out.println(ladderLength("hit","cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
    }

}
