package Bilibili.state;

public class TestPriority {
    public static void main(String[] args) {

        //主线程的默认优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        //新建5个线程观察优先级
        Thread[]  threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
           threads[i]= new Thread(myPriority);
        }


        //先设置优先级在启动
        threads[1].setPriority(1);
        threads[2].setPriority(4);
        //threads[2].setPriority(-1);
        threads[3].setPriority(8);
        //threads[3].setPriority(13);
        threads[4].setPriority(Thread.MAX_PRIORITY); // 10





        //同时start  和分别 start 影响大不大

        for(Thread thread : threads) {
            thread.start();
        }

    }


}

class  MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}