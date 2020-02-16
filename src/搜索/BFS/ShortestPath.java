package 搜索.BFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [[1,1,0,1],
 *  [1,0,1,0],
 *  [1,1,1,1],
 *  [1,0,1,1]]
 * 题目描述：0 表示可以经过某个位置，求解从左上角到右下角的最短路径长度。
 *
 * 队列
 *  第一次  (1,1) (1,0)
 *  第二次 (1,1) (2,1) (1,1)
 *  第三次 (0,2) (2,1) (1,1) (2,1)
 *  第四次  (3,2) (0,2) (2,1) (1,1)
 *  第五次 第六次 第七次
 *
 *                  1
 *                2  3
 *              4  5  6 7(假设在这里找到出口 下面就不用找了 所以最短路径就是这里)
 *             8 9 10 11
 *
 */
public class ShortestPath {
    public static void main(String[] args) {

        int[][] array = new int[][]{
                {1,1,0,1},
                {0,0,1,0},
                {1,0,1,1},
                {1,1,0,0}
        };
        int i = shortestPath(array);
        System.out.println(i);

    }

    public static int shortestPath(
            int[][] grids
    ) {
        /**
         * 假设 m*n的二维数组
         * 有几种情况撞墙 当前坐标（x,y）
         * (x,y) + (x1,y1)(direction)方向坐标
         * 如果 x + x1 < 0 左边越界
         * 如果 x + x1 >= n 右边越界
         * 如果 y + y1 < 0 上边越界
         * 如果 y + y1 >= m 下边越界
         * 并且要满足 (x+x1,y+y1)为按照方向走完后的坐标 可以按照原点理解 如下
         *
         * (-1,-1)(-1,0)(-1,1)
         *  (0,-1)(0,0)(0,1)
         *  (1,-1)(1,0)(1,1)
         *  遍历方向
         *  -> 下一层从左到右
         *  -> 同一层从左到右
         *  -> 上一层 从左到右
         *
         */
//        错误理解
//        int[][] direction = {// {x,y}轴
//                {1, -1},//向右一步 向上一步 ↗
//                {1, 0}, //向右一步 -→
//                {1, 1}, //向右一步 向下一步 ↘
//                {0, -1}, //向上一步 ↑
//                {0, 1}, //向下一步 ↓
//                {-1, -1},//向左一步 向上一步 ↖
//                {-1, 0},//向左一步 ←-
//                {-1, 1} //向左一步 向下一步 ↙
//        };

        int[][] direction = {// {x,y}轴
                {1, -1},
                {1, 0},
                {1, 1},
                {0, -1},
                {0, 1},
                {-1, -1},
                {-1, 0},
                {-1, 1}
        };

        int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                grids[cr][cc] = 1; // 标记
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] == 1) {
                        continue;
                    }
                    if (nr == m - 1 && nc == n - 1) {//到达终点
                        return pathLength + 1;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }
}
