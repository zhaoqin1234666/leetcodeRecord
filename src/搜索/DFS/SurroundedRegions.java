package 搜索.DFS;

/**
 * 填充封闭区域
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 题目描述：使被 'X' 包围的 'O' 转换为 'X'。
 *
 * 先填充最外侧，剩下的就是里侧了。
 *
 * 思路
 * 从四周 (四条边)用深度优先策略找到"0",深度优先遍历不到的就是封闭区域
 */
public class SurroundedRegions {
    private int m;
    private int n;
    private int[][] direction = new int[][]{
            {0, 1},//→
            {0, -1},//←
            {-1, 0},//↑
            {1, 0}//↓
    };

    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"X", "X", "X", "X"},
                {"X", "0", "0", "X"},
                {"X", "X", "0", "X"},
                {"X", "0", "X", "X"}
        };

        SurroundedRegions surroundedRegions = new SurroundedRegions();
        String[][] array2 = surroundedRegions.findNotSurroundedArea(array);
        for (String[] out : array2) {
            for (String in : out)
                System.out.print(in + " ");
            System.out.println();
        }
    }

    /**
     * 找到所有能够遍历到的区域,并用"T"代替
     * @return
     */
    public String[][] findNotSurroundedArea(String[][] array){
        m = array.length;
        n = array[0].length;

        // 从左 从右扫描
        for (int i = 0; i < m; i++){
            dfs(array, i, 0);
            dfs(array, i, n-1);
        }
        //从上 从下 扫描
        for (int j = 0; j < n; j++){
            dfs(array, 0, j);
            dfs(array, m-1, j);
        }
        //将标为"0"的变为"X" 标为"T"重新变回"0"
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                if(array[i][j] == "0") {
                    array[i][j] = "X";
                }
                else if(array[i][j] == "T"){
                    array[i][j] = "0";
                }

            }

        return array;
    }

    public void dfs(
            String[][] array,
            int i,//坐标
            int j //坐标
    ){
        if(i < 0 || i >= m || j < 0 || j >= n || array[i][j] != "0")
            return;
        array[i][j] = "T";//标记不是被包围的区域
        for (int[] d : direction) {
            dfs(array, d[0]+i, d[1]+j);
        }

    }


}
