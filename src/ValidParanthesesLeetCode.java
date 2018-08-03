import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */

public class ValidParanthesesLeetCode {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++){
            if(str[i]=='(' || str[i]=='{' || str[i]=='['){
                stack.push(str[i]);
            }
            else{
                if(stack.size()==0) return false;
                if(str[i]==')' && stack.peek()!='(') return false;
                if(str[i]=='}' && stack.peek()!='{') return false;
                if(str[i]==']' && stack.peek()!='[') return false;
                stack.pop();
            }
        }
        if(stack.size()==0) return true;
        else return false;
    }

    public static void main(String args[]){
        System.out.println(isValid("()}"));
        System.out.println(isValid("{()}"));
    }
}
