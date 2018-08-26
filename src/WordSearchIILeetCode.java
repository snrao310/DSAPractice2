import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 *
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 *
 */
public class WordSearchIILeetCode {

    private static class TrieNode{
        boolean isEnd;
        HashMap<Character,TrieNode> children;
        int index;
        TrieNode(){
            isEnd=false;
            children=new HashMap<>();
            index=-1;
        }
    }

    static int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root=buildTrie(words);
        List<String> result =new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                backtrackFunction(board,i,j,root,words,result);
            }
        }
        return result;
    }

    private static TrieNode buildTrie(String[] words){
        TrieNode root=new TrieNode();
        for(int ind=0;ind<words.length;ind++){
            TrieNode temp = root;
            char[] w=words[ind].toCharArray();
            int i=0;
            while(i<w.length){
                if(!temp.children.containsKey(w[i]))
                    temp.children.put(w[i], new TrieNode());
                temp=temp.children.get(w[i]);
                i++;
            }
            temp.isEnd=true;
            temp.index=ind;
        }
        return root;
    }

    private static void backtrackFunction(char[][] board, int i,int j, TrieNode root, String[] words, List<String> result){
        if(root.isEnd){
            result.add(words[root.index]);
            root.isEnd=false;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='#')
            return;

        if(root.children.containsKey(board[i][j])){
            char temp=board[i][j]; board[i][j]='#';
            for(int[] dir: dirs){
                int ii=i+dir[0], jj=j+dir[1];
                backtrackFunction(board,ii,jj,root.children.get(temp),words,result);
            }
            board[i][j]=temp;
        }
    }


    public static void main(String args[]){
        char[][] board=new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        List<String> list=findWords(board,new String[]{"oath","oathf","pea","eat","rain"});
        for(String s: list)
            System.out.print(s+" ");
    }
}
