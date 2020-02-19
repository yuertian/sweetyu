package nowCoder;

import java.util.Stack;

public class TowStackTOQeuen {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //入队列
        stack1.push(node);
    }

    public int pop() {
        //出队列
        //栈1元素依次出栈，再入栈2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        //栈顶元素出栈
        int first = stack2.pop();
        //栈2依次出栈，入栈1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return first;
    }
}
