package lesson3;

public class UnsafeThread {
    //有一个变量 count = 0 ； 同时启动20个线程 ， 循环1000次每次循环 count+1
    //等待20个子线程执行完毕之后，再main 线程打印count 值


    //线程共享这个变量 所以常量
    private static  int COUNT = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread [] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j =0 ; j < 1000;j++) {
                        COUNT++;
                    }
                }
            });
        }

        //尽量同时启动，不让new 线程操作耗时影响
        for(Thread t  : threads){
            t.start();
        }

        //让main 线程等待所有的线程执行完毕
        for(Thread t : threads){
            t.join();
        }
        System.out.println(COUNT);


    }
}
