package 双指针;


/**
 * 题目描述：在有序数组中找出两个数，使它们的和为 target。
 *
 * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 *
 * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
 * 如果 sum > target，移动较大的元素，使 sum 变小一些；
 * 如果 sum < target，移动较小的元素，使 sum 变大一些。
 * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)
 * 2 7 11 15
 */
public class TwoSum {

    public static void main(String[] args) {
        int [] array = new int[]{2,7,11,15};
        int[] subscriptArrays= TwoSum.twoSum(array, 13);

        if (null != subscriptArrays){
            for (int item : subscriptArrays) {
                System.out.println(item);
            }
        }

    }

    public static int[] twoSum(
            int []array,//有序数组
            int target  //需要计算的目标值
    ){
        int i = 0; int j = array.length-1;
        while (j > i){
            int sum = array[i] + array[j];
            if(sum > target){
                j--;
            }
            else if(sum < target){
                i++;
            }
            else {
                return new int[]{i+1,j+1};
            }
        }
        return null;
    }


}
