package 搜索.Backtracking;

/**
 *For example,
 * Given board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch {
    private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;

    public static void main(String[] args) {

           char[][] array = new char[][]{
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
                    };
        WordSearch wordSearch = new WordSearch();
        boolean isExixt = wordSearch.exist(array, "SEE");
        System.out.println(isExixt);
    }

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (backtracking(0, r, c, hasVisited, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtracking(int curLen, int r, int c, boolean[][] visited, final char[][] board, final String word) {
        if (curLen == word.length()) {
            return true;
        }
        if (r < 0 || r >= m || c < 0 || c >= n
                || board[r][c] != word.charAt(curLen) || visited[r][c]) {

            return false;
        }

        visited[r][c] = true;

        for (int[] d : direction) {
            if (backtracking(curLen + 1, r + d[0], c + d[1], visited, board, word)) {
                return true;
            }
        }

        visited[r][c] = false;

        return false;
    }
}
