/**
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 */
public class WordSearchLeetCode {

    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0))
                    if(DFS(board,i,j,new boolean[board.length][board[0].length],word,0))
                        return true;
            }
        }
        return false;
    }

    static int[][] dirns=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};


    private static boolean DFS(char[][] board,int i,int j,boolean[][] visited,String word,int start){
        if(start==word.length()) return true;
        if(i<0 || i==board.length || j<0 || j==board[0].length || visited[i][j]) return false;
        if(board[i][j]!=word.charAt(start)) return false;
        visited[i][j]=true;
        for(int[] dir: dirns){
            if(DFS(board,i+dir[0],j+dir[1],visited,word,start+1))
                return true;
        }
        visited[i][j]=false;
        return false;
    }

    public static void main(String args[]){
        char[][] input=new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(exist(input,"ABCEFSADEESE"));
        System.out.println(exist(input,"SEE"));
        System.out.println(exist(input,"ABCB"));

    }
}
