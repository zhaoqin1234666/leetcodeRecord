package 双指针;

/**
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 *
 * 所谓的回文字符串，是指具有左右对称特点的字符串，例如 "abcba" 就是一个回文字符串。
 *
 * 使用双指针可以很容易判断一个字符串是否是回文字符串：令一个指针从左到右遍历，一个指针从右到左遍历，这两个指针同时移动一个位置，每次都判断两个指针指向的字符是否相同，如果都相同，字符串才是具有左右对称性质的回文字符串。
 *
 *
 *
 * 本题的关键是处理删除一个字符。在使用双指针遍历字符串时，如果出现两个指针指向的字符不相等的情况，我们就试着删除一个字符，再判断删除完之后的字符串是否是回文字符串。
 *
 * 在判断是否为回文字符串时，我们不需要判断整个字符串，因为左指针左边和右指针右边的字符之前已经判断过具有对称性质，所以只需要判断中间的子字符串即可。
 *
 * 在试着删除字符时，我们既可以删除左指针指向的字符，也可以删除右指针指向的字符。
 */
public class ValidPalindrome {

    public static void main(String[] args) {
//        String s = "abaaabacba";
        String s = "abca";
        ValidPalindrome instanse = new ValidPalindrome();
        Boolean flag = instanse.isPalindrome(s);
        System.out.println(flag);
    }

    /**
     * 判断是否是回文字符串
     * @return
     */
    public Boolean isPalindrome(String s){
        for (int i = 0 , j = s.length()-1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return isPalindromeAfterDeletion(s, i+1, j) || isPalindromeAfterDeletion(s, i, j-1);
            }
        }
        return true;
    }

    /**
     * 在删除一个字符之后，判断是否为回文字符串
     */
    public Boolean isPalindromeAfterDeletion(
            String s,
            int start,
            int end
            ){
        for (int i = start, j = end; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
