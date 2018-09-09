/**
 *
 * Implement atoi to convert a string to an integer.
 *
 */
public class StringToIntegerAtoiLeetCode {

    public static int myAtoi(String str) {
        char st[] = str.toCharArray();
        boolean isNegative = false;
        int i=0;
        while(i<st.length && st[i]==' ')i++;
        if(i==st.length) return 0;
        if(st[i]=='+' || st[i]=='-'){
            isNegative = (st[i]=='-');
            i++;
        }
        long result = 0;
        while(i<st.length && Character.isDigit(st[i])){
            int num = Character.getNumericValue(st[i]);
            result=(result*10)+num;
            if(isNegative && (-result)<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(!isNegative && result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i++;
        }
        return (isNegative)?(int)(-result):(int)result;
    }

    public static void main(String args[]){
        System.out.print(myAtoi("     010 1"));
    }
}
