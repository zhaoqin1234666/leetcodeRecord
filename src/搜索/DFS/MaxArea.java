package 搜索.DFS;

/**
 * {{0,0,1,0,0,0,0,1,0,0,0,0,0},
 *  {0,0,0,0,0,0,0,1,1,1,0,0,0},
 *  {0,1,1,0,1,0,0,0,0,0,0,0,0},
 *  {0,1,0,0,1,1,0,0,1,0,1,0,0},
 *  {0,1,0,0,1,1,0,0,1,1,1,0,0},
 *  {0,0,0,0,0,0,0,0,0,0,1,0,0},
 *  {0,0,0,0,0,0,0,1,1,1,0,0,0},
 *  {0,0,0,0,0,0,0,1,1,0,0,0,0}}
 */
public class MaxArea {

    private int m, n;
    private int[][] direction = {
                {0, 1},//→
                {0, -1}, //←
                {1, 0}, //↓
                {-1, 0}//↑
    };

    public static void main(String[] args) {
        int[][]  array = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        MaxArea maxArea = new MaxArea();
        int i = maxArea.maxArea(array);
        System.out.println(i);
    }

    public int maxArea(int[][] array){
        int maxArea = 0;
        m = array.length;//y轴最大坐标 超过则越下界
        n = array[0].length;//x轴最大最大坐标，超过则越右界
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) {
                int area = dfs(array, i, j);
                if (maxArea < area)
                    maxArea = area;
            }
        return maxArea;
    }

    /**
     *深度遍历求连通长度
     */
    public int dfs(int[][] array,int i,int j){
        if(i < 0 || i >= m || j < 0 || j >= n || array[i][j] == 0)
            return 0;

        array[i][j] = 0;
        int area = 1;
        for (int[] d : direction) {
           area += dfs(array, d[0]+i, d[1]+j);
        }
        return area;
    }

}
