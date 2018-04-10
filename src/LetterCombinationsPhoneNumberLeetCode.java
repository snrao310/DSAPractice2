import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterCombinationsPhoneNumberLeetCode {

    private static HashMap<Integer, char[]> charMap = new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0) return result;
        initializeCharMap();
        backtrack(digits,result, new StringBuilder(), 0);
        return result;
    }

    private static void backtrack(String digits, List<String> result, StringBuilder tempString,int start){
        if(start==digits.length()) {
            result.add(tempString.toString());
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(start));
        char[] alphabets = charMap.get(digit);
        for(char c: alphabets){
            tempString.append(c);
            backtrack(digits, result, tempString, start+1);
            tempString.deleteCharAt(tempString.length()-1);
        }
    }

    private static void initializeCharMap(){
        charMap.put(2, new char[]{'a','b','c'});
        charMap.put(3, new char[]{'d','e','f'});
        charMap.put(4, new char[]{'g','h','i'});
        charMap.put(5, new char[]{'j','k','l'});
        charMap.put(6, new char[]{'m','n','o'});
        charMap.put(7, new char[]{'p','q','r','s'});
        charMap.put(8, new char[]{'t','u','v'});
        charMap.put(9, new char[]{'w','x','y','z'});
    }


    public static void main(String args[]){
        System.out.println(letterCombinations("5"));
    }
}
