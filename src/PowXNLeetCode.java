/**
 *
 * Implement pow(x, n).
 *
 */
public class PowXNLeetCode {

    public static double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        long nn = n;
        if(n<0) {
            nn*=(-1);
            x = (1.0/x);
        }
        double halfPow = myPow(x, (int)(nn/2));
        if(nn%2==0)
            return halfPow*halfPow;
        else
            return halfPow*halfPow*x;
    }

    public static void main(String args[]){
        System.out.println(myPow(2.00000, -2147483648));
    }
}
