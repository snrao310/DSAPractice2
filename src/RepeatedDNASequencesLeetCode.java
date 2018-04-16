import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When
 * studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * For example,
 *
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 */
public class RepeatedDNASequencesLeetCode {


    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> visited=new HashSet<>(), resultSet = new HashSet<>();
        for(int i=0; i+10 <= s.length(); i++){
            String sub = s.substring(i,i+10);
            if(visited.contains(sub))
                resultSet.add(sub);
            visited.add(sub);
        }
       return new ArrayList<String>(resultSet);
    }


    public static void main(String args[]){
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
