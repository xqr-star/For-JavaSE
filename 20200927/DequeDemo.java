package use_jdk;

import java.util.LinkedList;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {
        Deque <Integer> deque = new LinkedList<>();
//        deque.addFirst(1);
//        deque.addFirst(2);
//        deque.addFirst(3);
//        //add默认尾插法
//        deque.addLast(5);
//        deque.addLast(6);
//        deque.add(4);
//        System.out.println(deque);

        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        //offer默认尾插法
        deque.offer(5);
        System.out.println(deque);
        System.out.println("element");
        System.out.println(deque.element());
//        System.out.println(deque.size());

        //get 只看不取
//        System.out.println(deque.getFirst());
//        System.out.println(deque.getFirst());
//        System.out.println(deque.getFirst());
//        System.out.println(deque.getLast());
//
//        System.out.println(deque.size());

        System.out.println("peek操作");
        //peek==peekFirst
        System.out.println(deque.peek());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        System.out.println("remove操作");


        System.out.println(deque.removeFirst());
//        deque.remove();
//        deque.remove(5);
//        System.out.println(deque);

        //  remove 默认删除首元素
        //remove返回值是删除的元素
        System.out.println(deque.remove());

        //poll 默认删除首元素
        System.out.println(deque.poll());
        System.out.println(deque.pollLast());


        //抛出异常
        //System.out.println(deque.remove());

        //返回值是Null
        //System.out.println(deque.poll());


        System.out.println(deque);

    }

}
