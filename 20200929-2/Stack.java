package Oj;

import java.util.LinkedList;
import  java.util.Queue;

public class Stack {
        private Queue<Integer> queue;
        /** Initialize your data structure here. */
        public Stack() {
                queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
                queue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
                //控制循环次数
                for(int i = 0 ;i<queue.size()-1;i++) {
                        //先把元素挪出来
                        Integer e = queue.remove();
                        //再把元素放回去
                        queue.add(e);
                }
                return queue.remove();
        }

        /** Get the top element. */
        public int top() {
                for(int i = 0 ;i<queue.size()-1;i++) {
                        //先把元素挪出来
                        Integer e = queue.remove();
                        //再把元素放回去
                        queue.add(e);
                }
                Integer t =queue.remove();
                queue.add(t);
                return t;

//                return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
                return queue.isEmpty();
        }
    }

}
