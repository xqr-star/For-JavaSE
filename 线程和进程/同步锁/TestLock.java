package Bilibili.gaoji;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2,"1").start();
        new Thread(testLock2,"2").start();
        new Thread(testLock2,"3").start();

    }

}

class TestLock2 implements Runnable{


    private  int tickNumbs = 10;

    //定义Lock锁
    private  final  ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        while (true){
            //显示的定义锁
            lock.lock(); // 加锁
            try{
                //下面放不安全的代码
                if(tickNumbs > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"拿到了"+tickNumbs--+"票");
                }else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }

        }
    }
}