import java.util.Stack;

/**
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division
 * should truncate toward zero.
 * You may assume that the given expression is always valid.
 *
 */
public class BasicCalculatorIILeetCode {

    public static int calculate(String s) {
        int len = s.length(),res=0,curNum=0;
        if(len==0) return 0;
        char sign = '+';
        char[] st = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<=len;i++){
            if(i==len || !Character.isDigit(st[i])){
                if(i!=len && st[i]==' ')continue;
                if(sign=='*')
                    stack.push(stack.pop()*curNum);
                else if(sign=='/')
                    stack.push(stack.pop()/curNum);
                else if(sign=='-')
                    stack.push(-curNum);
                else
                    stack.push(curNum);
                if(i!=len) sign=st[i];
                curNum=0;
            }
            else{
                curNum=curNum*10 + Character.getNumericValue(st[i]);
            }
        }
        while(!stack.isEmpty())
            res+=stack.pop();
        return res;
    }

    public static void main(String args[]){
        System.out.print(calculate(" 3+5 / 2 "));
    }
}
