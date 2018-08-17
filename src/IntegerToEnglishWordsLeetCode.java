import java.util.HashMap;

/**
 *
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 -1.
 *
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 */
public class IntegerToEnglishWordsLeetCode {

    static String[] ones = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
    static String[] teens = {"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] tens = {"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static String[] powers = {"","Thousand","Million","Billion"};


    public static String numberToWords(int num) {
        if(num==0) return "Zero";
        String result="";
        int power=0;
        while(num>0){
            if(num%1000 !=0){
                String partialString = getPartialString(num%1000);
                if(powers[power].length()!=0)
                    partialString+=" " + powers[power];
                if(result.length()!=0)
                    partialString+= " " + result;
                result = partialString;
            }
            num/=1000;power++;
        }
        return result;
    }

    private static String getPartialString(int num){
        if(num==0) return "";
        if(num<=10) return ones[num-1];
        if(num<20) return teens[num-10-1];
        if(num<100){
            int one = num%10;
            int ten = num/10;
            return tens[ten-1] + ((one==0)?"":" "+ones[one-1]);
        }
        else{
            int hundred = num/100;
            return ones[hundred-1] + " Hundred" + ((num%100==0)?"":" "+getPartialString(num%100));
        }
    }


    public static void main(String args[]){
        System.out.println(numberToWords(123456));
        System.out.println(numberToWords(123000001));
        System.out.println(numberToWords(1000));
        System.out.println(numberToWords(13));
        System.out.println(numberToWords(1023010));
    }
}
