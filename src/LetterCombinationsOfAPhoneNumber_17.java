import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_17 {

    Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.isEmpty()) return res;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, new StringBuilder(), res);

        return res;
    }

    private void dfs(String digits, StringBuilder stringBuilder, List<String> res) {
        if(digits.isEmpty()) {
            res.add(stringBuilder.toString());
            return;
        };
        for(char c: map.get(digits.charAt(0)).toCharArray()){
            dfs(digits.substring(1), stringBuilder.append(c), res);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }



    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber_17().letterCombinations("23"));
    }
}
