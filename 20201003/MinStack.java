package Oj;
import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;//栈顶保证是栈1中最小元素的

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    public void push(int x) {
        //1 一定要进
        stack1.push(x);

        //2 选择性进

        if(stack2.isEmpty()) {
            stack2.push(x);
        }else {
            int e = stack2.peek();
            if (x < e) {
                stack2.push(x);
            } else {
                stack2.push(e);//实现两边栈的同步
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(9);
        minStack.push(11);
        minStack.push(1);

        System.out.println(minStack.getMin());

    }
}
