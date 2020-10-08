package impl;

public class MyCircularQueue {
    private final int []arr ;
    private  int size;
    private  int frontIndex;
    private  int rearIndex;
    //环队列的容量是k
    //构造函数

    public MyCircularQueue(int k) {
        arr = new int [k];
        size = 0;
    }


    //插入元素 value 插入尾部
    public boolean enQueue(int value) {
        if(size == arr.length) {
            return false;
        }
        arr[rearIndex] = value;
        size++;
        rearIndex++;
        //这一步很重要
        if(rearIndex == arr.length) {
            rearIndex = 0;
        }
        return true;
    }

    //删除元素 队首删除
    public boolean deQueue() {
        if(size == 0) {
            return false;
        }
        size--;
        frontIndex++;
        //这一步很重要
        if(frontIndex == arr.length) {
            frontIndex = 0;
        }
        return true;
    }
    //获取队首元素  --队列为空返回-1
    public int Front() {
        if(size == 0) {
            return -1;
        }
        return arr[frontIndex];
    }

   //获取队尾元素 --
    public int Rear() {
        if(size == 0) {
            return -1;
        }
        if(rearIndex == 0) {
            return arr[arr.length-1];
        }
        return arr[rearIndex-1];
    }

    //循环队列是否为空
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    //循环队列是否满了
    public boolean isFull() {
//        if(size == arr.length) {
//            return true;
//        }
//        return false;
        return size == arr.length;
    }
}
