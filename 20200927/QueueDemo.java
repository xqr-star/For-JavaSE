package use_jdk;

import java.util.Queue;

import java.util.LinkedList;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<> ();
        //FIFO

        //尾插法
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //System.out.println(queue);


        //都是1
//        System.out.println(queue.element());
//        System.out.println(queue.element());
//        System.out.println(queue.element());

        System.out.println(queue.offer(4));

        System.out.println(queue.size());
        System.out.println(queue.isEmpty());


        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.size());
        //队列为空 值为NUll
        System.out.println(queue.poll());


//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
        //System.out.println(queue.size());
        //队列为空，抛出异常
        //System.out.println(queue.remove());




    }
}
