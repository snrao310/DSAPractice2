/*
Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, then just return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:

List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.


Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
The system have already tracked down the following sentences and their corresponding times:
"i love you" : 5 times
"island" : 3 times
"ironman" : 2 times
"i love leetcode" : 2 times
Now, the user begins another search:

Operation: input('i')
Output: ["i love you", "island","i love leetcode"]
Explanation:
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.

Operation: input(' ')
Output: ["i love you","i love leetcode"]
Explanation:
There are only two sentences that have prefix "i ".

Operation: input('a')
Output: []
Explanation:
There are no sentences that have prefix "i a".

Operation: input('#')
Output: []
Explanation:
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.

Note:
The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
Please use double-quote instead of single-quote when you write test cases even for a character input.
Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */


import java.util.*;

public class DesignSearchAutocompleteSystemLeetCode {


    public static class AutocompleteSystem {

        private class TrieNode{
            boolean isEnd;
            int count;
            String word;
            HashMap<Character,TrieNode> children;
            TrieNode(){
                isEnd=false; count=0; children=new HashMap<>();
            }
        }

        TrieNode root, curNode;
        String curString;

        private void constructTrie(String[] sentences, int[] times){
            for(int i=0;i<sentences.length;i++){
                TrieNode temp=root;
                char[] st=sentences[i].toCharArray();
                for(int j=0;j<st.length;j++){
                    if(!temp.children.containsKey(st[j]))
                        temp.children.put(st[j],new TrieNode());
                    temp=temp.children.get(st[j]);
                }
                temp.isEnd=true;
                temp.word=sentences[i];
                temp.count=times[i];
            }
        }

        public AutocompleteSystem(String[] sentences, int[] times) {
            curString="";
            root=new TrieNode();
            curNode=root;
            constructTrie(sentences, times);
        }

        public List<String> input(char c) {
            List<String> results=new ArrayList<>();
            if(c!='#'){
                curString+=c;
                if(!curNode.children.containsKey(c))
                    curNode.children.put(c,new TrieNode());
                curNode=curNode.children.get(c);
                List<TrieNode> nodesList = new ArrayList<>();
                DFS(nodesList, curNode);
                Collections.sort(nodesList, new Comparator<TrieNode>(){
                    @Override
                    public int compare(TrieNode o1,TrieNode o2){
                        if(o1.count==o2.count)
                                return o1.word.compareTo(o2.word);
                        return o2.count-o1.count;
                    }
                });
                for(int i=0;i<3 && i<nodesList.size();i++) results.add(nodesList.get(i).word);
            }
            else{
                curNode.isEnd=true;
                curNode.word=curString;
                curNode.count++;
                curNode=root;
                curString="";
            }
            return results;
        }

        private void DFS(List<TrieNode> results, TrieNode node){
            if(node.isEnd)
                results.add(node);
            for(char c: node.children.keySet())
                DFS(results, node.children.get(c));
        }
    }

    public static void main(String args[]){
        AutocompleteSystem system = new AutocompleteSystem(new String[]{"i love you", "island","ironman", "i love leetcode"}, new int[]{5,3,2,2});
        System.out.println(system.input('i'));
        System.out.println(system.input(' '));
    }
}
