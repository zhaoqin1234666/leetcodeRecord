package 搜索.Backtracking;


/**
 * 主要思想
 *
 * 判断你填的数在这一列  这一行  这个小的3x3的数独里面是不是合法(没有重复的数字即合法)的
 *
 * 怎么找到坐标所在的3x3小数独
 * 计算公式  根据坐标(x,y)   行的范围 x/3 + (0-2)  纵坐标的范围 y/3 +(1-2)
 */
public class SudokuSolver {
    public static void main(String[] args) {
        char[][] array = new char[][]
        {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudo(array);

    }

    /**
     * 解数独
     * @param array
     * @return
     */
    public boolean solveSudo(char[][] array){
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++){
                if(array[i][j] != '.')
                    continue;
                for (char num = '1'; num <= '9'; num++) {
                    if(isValid(array, i, j, num)){
                        array[i][j] = num;
                        if(solveSudo(array)) return true;
                        array[i][j] = '.';
                    }
                }
                return false;
            }

        for (char[] d: array) {
            for (char c : d){
                System.out.print(c + " ");
            }
            System.out.println();
        }

        return true;
    }

    /**
     * 判断填的数字在这一行 这一列 所在3x3的小数独里面是否在(1-9)是不重复的数字
     * @return
     */
    public boolean isValid(char[][] array, int row, int col, int num){
        for (int i = 0; i < 9; i++){
            //判断所在列
            if(array[i][col] == num) return false;
            //所在行
            if(array[row][i] == num) return false;
            //所在小型3x3数独
            if(array[(row/3) * 3 + i / 3][(col/3) * 3  + i % 3] == num) return false;
        }
        return true;
    }




}
