import java.util.Stack;

/**
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 */
public class SimplifyPathLeetCode {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>(), stackRev=new Stack<>();
        String[] parts = path.split("/");
        for(String part: parts){
            if(part.equals(".") || part.equals("")) continue;
            if(part.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(part);
        }
        StringBuilder sb= new StringBuilder("/");
        while(!stack.isEmpty()) stackRev.push(stack.pop());
        while(!stackRev.isEmpty()){
            sb.append(stackRev.pop()+"/");
        }
        if(sb.length()>1)sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.println(simplifyPath("/..."));
    }
}
