import java.util.Stack;

/**
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 */
public class MinStackLeetCode {

    public static class MinStack {
        /** initialize your data structure here. */
        Stack<Integer> stack;
        Stack<Integer> minStack;
        int size=0;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
            size = 0;
        }

        public void push(int x) {
            stack.push(x);
            if(size==0 || minStack.peek()>=x){
                minStack.push(x);
            }
            size++;
        }

        public void pop() {
            if(size==0) return;
            int x = stack.pop();
            if(x==minStack.peek())
                minStack.pop();
            size--;
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String args[]){
        /**
         * Your MinStack object will be instantiated and called as such:
         * MinStack obj = new MinStack();
         * obj.push(x);
         * obj.pop();
         * int param_3 = obj.top();
         * int param_4 = obj.getMin();
         */

        MinStack obj=new MinStack();
        obj.push(5);
        obj.push(2);
        obj.push(6);
        obj.push(4);
        obj.pop();
        obj.push(8);
        obj.push(2);
        obj.push(5);
        System.out.println(obj.getMin());
        obj.pop();
        obj.pop();
        System.out.println(obj.getMin());
    }
}
