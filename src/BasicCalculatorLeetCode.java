import java.util.Stack;

/**
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers
 * and empty spaces .
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 *
 */
public class BasicCalculatorLeetCode {

    //Stack operations. Not that hard.
    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        int start=-1,result=0;
        for(int i=0;i<=s.length();i++){
            char c = (i==s.length())?' ':s.charAt(i);
            if(i==s.length() || c==')'){
                if(start!=-1) stack.push(s.substring(start,i));
                result =0;
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    int k = Integer.parseInt(stack.pop().trim());
                    String op = "+";
                    if(!stack.isEmpty() && !stack.peek().equals("(")) op=stack.pop();
                    result=(op.equals("+"))?result+k:result-k;
                }
                if(!stack.isEmpty())stack.pop();
                stack.push(Integer.toString(result));
                start=-1;
            }
            if(start==-1 && Character.isDigit(c)) start=i;
            if(c=='+' || c=='-' || c=='('){
                if(start!=-1) stack.push(s.substring(start,i));
                stack.push(s.substring(i,i+1));
                start=-1;
            }
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(calculate("1 + 1 "));
        System.out.println(calculate("(  3 ) "));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
