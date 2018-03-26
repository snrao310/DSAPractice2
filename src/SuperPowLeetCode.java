/**
 *
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer
 * given in the form of an array.
 *
 * Example1:
 * a = 2
 * b = [3]
 * Result: 8
 *
 * Example2:
 * a = 2
 * b = [1,0]
 * Result: 1024
 *
 */
public class SuperPowLeetCode {

    //f(a,1234567) = [f(a, 1234560) * f(a, 7)] % 1337 = [f(f(a, 123456),10) * f(a,7)] %1337
    public static int superPow(int a, int[] b) {
        return superPow(a,b,b.length-1);
    }

    private static int superPow(int a, int[] b, int end){
        if(end==0) return myPowerFunction(a,b[end]);
        return (myPowerFunction(superPow(a,b,end-1),10) * myPowerFunction(a,b[end]))%1337;
    }

    private static int myPowerFunction(int a, int p){
        int result =1; a%=1337;
        for(int i=0;i<p;i++){
            result*=a;
            result%=1337;
        }
        return result;
    }


    public static void main(String args[]) {
        System.out.println(superPow(2147483647, new int[]{2,0,0}));
    }

}
