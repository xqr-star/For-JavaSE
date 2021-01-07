package lesson3;

public class SafeThread2 {
    private static int COUNT = 0;

    public synchronized static void decrement() {
        COUNT--;
    }

    public synchronized static void increment () {
        COUNT++;
        decrement(); // 不会产生自己把自己锁死的问题
    }

    public static void main (String[]args) throws InterruptedException {

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        //synchronized 同步代码块
                        increment();
                    }
                }
            });
        }
        //尽量同时启动，不让new 线程操作耗时影响
        for (Thread t : threads) {
            t.start();
        }
        //让main 线程等待所有的线程执行完毕
        for (Thread t : threads) {
            t.join();
        }
        System.out.println(COUNT);

    }
}
