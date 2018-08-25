import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Given an array of strings, group anagrams together.
 *
 */
public class GroupAnagramsLeetCode {

    private static class Chars{
        int[] chars = new int[26];
        Chars(String s){
            for(int i=0;i<s.length();i++){
                chars[s.charAt(i)-'a']++;
            }
        }
        @Override
        public int hashCode(){
            return Arrays.toString(chars).hashCode();
        }
        @Override
        public boolean equals(Object o){
            return o.hashCode()==this.hashCode();
        }
    }

    //This method is algorithmically better than sorting string and storing as key in hashmap.
    //sorting generates key in O(klogk) wehere k is length of string, while this method generates key in O(k).
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<Chars,List<String>> map = new HashMap<>();
        for(String str: strs){
            Chars obj = new Chars(str);
            if(!map.containsKey(obj))
                map.put(obj,new ArrayList<>());
            map.get(obj).add(str);
        }
        for(List<String> l: map.values())
            result.add(l);
        return result;
    }

    public static void main(String args[]){
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> l=groupAnagrams(strs);
        for(List<String> li:l){
            for(String s:li)
                System.out.print(s+" ");
            System.out.println();
        }
    }
}
