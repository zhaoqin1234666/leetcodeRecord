package 二分查找;

/**
 * Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
 * Output: 2
 * 题目描述：一个有序数组只有一个数不出现两次，找出这个数。
 *
 * 要求以 O(logN) 时间复杂度进行求解，因此不能遍历数组并进行异或操作来求解，这么做的时间复杂度为 O(N)。
 *
 * 令 index 为 Single Element 在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
 *
 * 从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
 *
 * 因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式。
 *
 *
 * 0 8
 * num[4] != num[5] end = 5
 * 0 5
 * num[2] != num[3] end = 3
 * 0 3   mid = 1
 * num[0] == num[1] start 2
 * 2 3
 * num[2] != num[3] end = 3
 *
 *
 *
 */
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        int singleElementIndex = SingleElementInASortedArray.findSingleElementIndex(num);
        System.out.println(singleElementIndex);
    }

    public static  int findSingleElementIndex(int[] num){
        int start = 0; int end = num.length-1;
        while (start < end){
            int mid = (start + end)/2;
            if(mid%2 != 0)
                mid--;
            if (num[mid] == num[mid+1])
                start = mid + 2;
            else
//                end = mid + 1;
                end = mid;
        }
        return num[start];
    }

}
