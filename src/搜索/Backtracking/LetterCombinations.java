package 搜索.Backtracking;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    private String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        LetterCombinations instanse = new LetterCombinations();
        List<String> combinations = instanse.letterCombinations("23");
        for (String combination : combinations) {
            System.out.print(combination + " ");
        }
    }

    /**
     * 求出所有排列组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits){
        List<String> combinations = new ArrayList<>();
        doCombinations(new StringBuffer(), combinations, digits);
        return combinations;
    }

    public void doCombinations(
            StringBuffer prefix,
            List<String> combinations,
            String digits
    ){
        if(prefix.length() == digits.length()){
            combinations.add(prefix.toString());
            return;
        }
        int curDigit = digits.charAt(prefix.length()) - '0';
        String letter = KEYS[curDigit];
        for (char c : letter.toCharArray()) {
            prefix.append(c);
            doCombinations(prefix,combinations,digits);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
