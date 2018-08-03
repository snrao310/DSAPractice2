import java.util.HashMap;
import java.util.HashSet;

/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.


Note:

1 <= paragraph.length <= 1000.
1 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
Different words in paragraph are always separated by a space.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>();
        HashMap<String, Integer> wordCount= new HashMap<>();
        for(String a: banned)
            bannedSet.add(a);

        int max = 0;
        String curMaxWord = "";
        StringBuilder word = new StringBuilder();
        char[] para = paragraph.toCharArray();
        for(int i=0;i<para.length;i++){
            if(Character.isLetter(para[i])){
                word.append(Character.toLowerCase(para[i]));
            }
            if(!Character.isLetter(para[i]) || i==para.length-1){
                if(word.length()==0) continue;
                String wordString = word.toString();
                if(!bannedSet.contains(wordString)) {
                    wordCount.put(wordString, wordCount.getOrDefault(wordString, 0) + 1);
                    if (wordCount.get(wordString) > max) {
                        max = wordCount.get(wordString);
                        curMaxWord = wordString;
                    }
                }
                word = new StringBuilder();
            }
        }
        return curMaxWord;
    }

    public static void main(String args[]){
        String a = mostCommonWord("Bob hit a ball, the hit BALL flew far after it flew flew", new String[]{"hit"});
        System.out.println(a);
    }
}
