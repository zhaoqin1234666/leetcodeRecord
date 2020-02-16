package 双指针;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 * 题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
 *
 * 通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
 */
public class LoongestSubSequence {
    public static void main(String[] args) {

        String s = "abpcplea";
        List<String> words = Arrays.asList("ale", "apple", "monkey", "plea", "aplea");
        LoongestSubSequence instanse = new LoongestSubSequence();
        String longestWord = instanse.findLongestWord(s, words);
        System.out.println(longestWord);

    }

    public String findLongestWord(String s, List<String> words){
        String longestWord = "";//存储最长的子序列
        for (String word : words) {
            int l1 = longestWord.length(); int l2 = word.length();
            if(l1 > l2 || (l2 == l1 && longestWord.compareTo(word) > 0))
                continue;

            //是否是子序列
            if(isSubStr(s,word))
                longestWord = word;
        }
        return longestWord;
    }

    public Boolean isSubStr(String s, String target){
        int i = 0; int j = 0;
        while(i < target.length() && j < s.length()){
            if(target.charAt(i) == s.charAt(j))
                i++;
            else
                j++;
        }
        return i == target.length();
    }
}
