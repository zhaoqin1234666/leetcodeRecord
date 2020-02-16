package 二分查找;

/**
 * Input: 4
 * Output: 2
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 * 一个数 x 的开方 sqrt 一定在 0 ~ x 之间，并且满足 sqrt == x / sqrt。可以利用二分查找在 0 ~ x 之间查找 sqrt。
 *
 * 对于 x = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。在循环条件为 l <= h 并且循环退出时，h 总是比 l 小 1，也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。
 */
public class SquareRoot {
    public static void main(String[] args) {
        int squareRoot = SquareRoot.findSquareRoot(8);
        System.out.println(squareRoot);
    }

    public static int findSquareRoot(int n){
        int start = 1;
        int end = n;
        int mid;
        while(start <= end){
            mid = (start + end)/2;
            if(mid*mid > n){
                end = mid - 1;
            }
            else if(mid*mid < n){

                start = mid + 1;
            }
            else
                return mid;
        }
        return end;
    }
}
