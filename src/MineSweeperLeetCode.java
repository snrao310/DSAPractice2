import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by S N Rao on 4/5/2017.
 *
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an
 * unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and
 * all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
 * finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the
 * board after revealing this position according to the following rules:
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its
 * adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8')
 * representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 * Example 1:
 * Input:
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * Click : [3,0]
 * Output:
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 *
 * Example 2:
 * Input:
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * Click : [1,2]
 * Output:
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'X', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 *
 * Note:
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least
 * one clickable square.
 * The input board won't be a stage when game is over (some mines have been revealed).
 * For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all
 * the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 *
 */

public class MineSweeperLeetCode {

    private static int[][] dirns = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};

    public static char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M')
            board[click[0]][click[1]] = 'X';
        else
            DFS(board,click[0],click[1],new boolean[board.length][board[0].length]);
//            BFS(board,click);
        return board;
    }


    private static void DFS(char[][] board,int x, int y,boolean[][] visited){
        if(visited[x][y])
            return;

        visited[x][y] = true;
        int mineCount=0;
        for(int[] d: dirns){
            int i = x + d[0], j = y + d[1];
            if(i<0 || i>=board.length || j<0 || j>=board[0].length) continue;
            if(board[i][j] == 'M') mineCount++;
        }
        if(mineCount!=0) {
            board[x][y]=(char) (mineCount+'0');
            return;
        }
        else board[x][y]='B';
        for(int[] d: dirns){
            int i = x + d[0], j = y + d[1];
            if(i<0 || i>=board.length || j<0 || j>=board[0].length) continue;
            DFS(board,i,j,visited);
        }
    }

    private static void BFS(char[][] board,int[] click){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        queue.offer(click);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int mineCount=0;
            for(int[] d: dirns){
                int i = cur[0] + d[0], j = cur[1] + d[1];
                if(i<0 || i>=board.length || j<0 || j>=board[0].length) continue;
                if(board[i][j] == 'M') mineCount++;
            }

            board[cur[0]][cur[1]]=(char) (mineCount+'0');
            if(mineCount!=0) continue;
            else board[cur[0]][cur[1]]='B';

            for(int[] d: dirns){
                int i = cur[0] + d[0], j = cur[1] + d[1];
                if(i<0 || i>=board.length || j<0 || j>=board[0].length) continue;
                if(!visited[i][j]){
                    visited[i][j]=true;
                    queue.offer(new int[]{i,j});
                }
            }
        }
    }

    public static void main(String args[]){
        char[][] board={{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}};

        board=updateBoard(board,new int[]{3,0});
        for(char[] cArr: board)
            System.out.println(Arrays.toString(cArr));
        System.out.println();

        board=updateBoard(board,new int[]{1,2});
        for(char[] cArr: board)
            System.out.println(Arrays.toString(cArr));
    }
}
