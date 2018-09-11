import java.util.Stack;

/**
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 *
 */
public class EvaluateReversePolishNotationLeetCode {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String cur = tokens[i];
            if(cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")){
                int a=Integer.parseInt(stack.pop());
                int b=Integer.parseInt(stack.pop());
                stack.push(Integer.toString(calculate(b,cur.charAt(0),a)));
            }
            else stack.push(cur);
        }
        return Integer.parseInt(stack.pop());
    }

    private static int calculate(int x, char op, int y){
        switch (op){
            case '+': return x+y;
            case '-': return x-y;
            case '*': return x*y;
            case '/': return x/y;
            default: return -1;
        }
    }

    public static void main(String args[]){
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
