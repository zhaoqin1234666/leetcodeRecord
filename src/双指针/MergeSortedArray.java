package 双指针;

/**
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 * 题目描述：把归并结果存到第一个数组上。
 *
 * 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值
 * 情况一
 * 789000
 * 456
 * 情况二
 * 123000
 * 456
 * 情况三
 * 1789000
 * 456
 * 情况四
 * 567000
 * 489
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int [] nums1 = new int[]{1,2,3,0,0,0};
        int [] nums2 = new int[]{4,5,6};
        int[] mergeSortedArray = MergeSortedArray.mergeSortedArray(nums1, 3, nums2, 3);
        for (int item : mergeSortedArray) {
            System.out.print(item + " ");
        }

    }

    public static int[] mergeSortedArray(
            int []nums1,
            int m,
            int []nums2,
            int n
    ){
        int index1 = m-1; int index2 = n-1; int indexMerge = m+n-1;
        while (index1 >= 0 || index2 >= 0){
            if(index1 < 0){
                nums1[indexMerge--] = nums2[index2--];
            }
            else if(index2 < 0){
                nums1[indexMerge--] = nums1[index1--];
            }
            else if(nums1[index1] < nums2[index2]){
                nums1[indexMerge--] = nums2[index2--];
            }
            else{
                nums1[indexMerge--] = nums1[index1--];
            }
        }
        return nums1;
    }
}

