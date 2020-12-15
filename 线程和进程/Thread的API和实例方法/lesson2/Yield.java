package lesson2;

public class Yield {
    public static void main(String[] args) throws InterruptedException {
        Thread [] threads = new Thread[20];
        for(int i = 0; i <20 ;i++) {
            final int n = i; // 内部类使用外部的变量必须是final 修饰 和JVM 有关
            //子线程休眠三秒之后，无序运行
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(n);
                }
            });
        }
        for(Thread t : threads) {
            t.start();
            //t.join();  这个表示一个启动后main 等待它执行完 在启动下一个 打印的结果是顺序的
        }

        // 但实际中不会这么用
        //静态方法：作用是在当前线程 -- 当前代码所在的线程是main -- 只能使用debug
//        while (Thread.activeCount() > 1) {
//            Thread.yield(); // 让当前线程让步 ： 21个线程
//        }
        // 会采用join 操作
        for(Thread t: threads) {
            t.join(); // 这个表示的是同时启动之后， //
            //如果一个线程还没有执行就让main 等待sa
            // 如果一个线程在这之前已经执行完了，就告诉main 否则我会一直等待
        }


        System.out.println("ok");
    }
}
