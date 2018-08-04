import java.util.ArrayList;
import java.util.List;

/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

 */

public class PartitionLabelsLeetCode {

    public static List<Integer> partitionLabels(String S) {

        int last[] = new int[26];

        for(int i=0;i<S.length();i++){
            last[S.charAt(i) - 'a'] = i;
        }

        int curPartition =-1, curLength=0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(last[c-'a']>curPartition){
                curPartition = last[c-'a'];
                curLength++;
            }
            else{
                curLength++;
            }

            if(curPartition == i){
                result.add(curLength);
                curPartition = -1;
                curLength = 0;
            }
        }

        return result;

    }


    public static void main(String args[]){
        List<Integer> res = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(res);
    }
}
