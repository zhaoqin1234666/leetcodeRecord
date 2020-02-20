package 搜索.Backtracking;


import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * n 皇后 保证每一列 每一行 每一个对角线 只有一个皇后
 */
public class Nqueens {
    public static void main(String[] args) {
        List<List<String>> resultList = new ArrayList<>();
        char[][] board = new char[8][8];

        Nqueens nqueens = new Nqueens();
        nqueens.init(board);
        nqueens.solveQueens(resultList, board, 0);

        for (List<String> queen : resultList) {
            for(String s : queen){
                System.out.println(s);
            }
            System.out.println();
        }
    }

    /**
     * 初始化二维数组
     * @param board
     */
    public void init(char[][] board){
       for (int i = 0; i < board.length; i++){
           Arrays.fill(board[i], '.');
       }
    }

    public void solveQueens(List<List<String>> list, char[][] board, int rowIndex){
        if(rowIndex == board.length) {
            list.add(charArrayConvertToList(board));
            return;
        }

        for (int colIndex = 0; colIndex < board.length; colIndex++){
            if(isValid(board, rowIndex, colIndex)){
                board[rowIndex][colIndex] = 'Q';
                solveQueens(list, board, rowIndex + 1);
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int rowIndex, int colIndex){
        //行
        for (int i = 0; i < board.length; i++)
            if(board[rowIndex][i] == 'Q') return false;
        //列
        for (int i = 0; i < board.length; i++)
            if(board[i][colIndex] == 'Q') return false;
        //左对角线
        for(int i = rowIndex - 1, j = colIndex -1; i >= 0 && j >= 0; i--, j--)
            if(board[i][j] == 'Q') return false;
        //右对角线
        for(int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j <= board.length - 1; i--, j++)
            if(board[i][j] == 'Q') return false;

        return true;
    }

    /**
     * char[][]数组转化为List<String></>
     * @param board
     * @return
     */
    public List<String> charArrayConvertToList(char[][] board){
        ArrayList<String> list = new ArrayList<>();
        for (char[] row : board) {
            StringBuffer buffer = new StringBuffer();
            for (char c : row){
                buffer.append(c);
            }
            list.add(buffer.toString());
        }
        return list;
    }

}
