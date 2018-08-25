import java.util.HashMap;

/**
 * Created by S N Rao on 1/17/2017.
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class ImplementTrieLeetCode {

    private static class Trie {

        private class TrieNode{
            boolean isEnd;
            HashMap<Character,TrieNode> children;
            TrieNode(){
                isEnd=false;
                children = new HashMap<>();
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode temp = root;
            char[] w = word.toCharArray();
            int i=0;
            while(i<w.length && temp.children.containsKey(w[i])){
                temp = temp.children.get(w[i]);
                i++;
            }
            while(i<w.length){
                TrieNode newNode = new TrieNode();
                temp.children.put(w[i],newNode);
                temp = newNode;
                i++;
            }
            temp.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode temp = root;
            char[] w = word.toCharArray();
            int i=0;
            while(i<w.length && temp.children.containsKey(w[i])){
                temp = temp.children.get(w[i]);
                i++;
            }
            return i==w.length && temp.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode temp = root;
            char[] w = prefix.toCharArray();
            int i=0;
            while(i<w.length && temp.children.containsKey(w[i])){
                temp = temp.children.get(w[i]);
                i++;
            }
            return i==w.length;
        }
    }

    public static void main(String args[]) {
        // Your Trie object will be instantiated and called as such:
        Trie trie = new Trie();
        trie.insert("Sameeran");
        trie.insert("Medha");
        trie.insert("Varchas");
        System.out.println(trie.search("Sam"));
        trie.insert("Sam");
        System.out.println(trie.search("Sam"));
        System.out.println(trie.search("Sameerana"));
        System.out.println(trie.search("Sameeran"));
        System.out.println(trie.search("Medha"));
        System.out.println(trie.startsWith("Sam"));
        System.out.println(trie.startsWith("Va"));
        System.out.println(trie.startsWith("Varchas"));

    }
}
