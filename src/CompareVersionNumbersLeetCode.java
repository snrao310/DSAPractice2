/**
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 */
public class CompareVersionNumbersLeetCode {


    public static int compareVersion(String version1, String version2) {
        String[] v1= version1.split("\\.");
        String[] v2= version2.split("\\.");
        int i;
        for(i=0;i<v1.length || i<v2.length;i++){
            int v1Num = (i>=v1.length)?0:Integer.parseInt(v1[i]);
            int v2Num = (i>=v2.length)?0:Integer.parseInt(v2[i]);
            if(v1Num>v2Num) return 1;
            else if(v1Num<v2Num) return -1;
        }
        return 0;
    }

    public static void main(String args[]){
        System.out.println(compareVersion("1.1.1","1.01.1"));
//        System.out.println(compareVersion("1.0","1"));
    }
}
