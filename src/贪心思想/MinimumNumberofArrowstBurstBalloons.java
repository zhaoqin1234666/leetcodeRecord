package 贪心思想;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstBurstBalloons {
    public static void main(String[] args) {

        int[][] array = {{10,16}, {2,8}, {1,6}, {7,12}};
        Arrays.sort(array, Comparator.comparingInt(o -> o[1]));
        for (int[] array1 : array){
            for (int item : array1) {
                System.out.print(item + " ");
            }
            System.out.println();
        }


    }
}
