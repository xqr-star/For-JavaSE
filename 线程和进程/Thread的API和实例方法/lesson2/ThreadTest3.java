package lesson2;

public class ThreadTest3 {
    // t 和 main 同时并发并行的执行 ，但是因为main 线程正处于运行态执行代码，
    // 打印main 和t 本来应该是乱序，但先打印main 的几率更高
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t");
            }
        });
        t.start();
        System.out.println("main");
    }
}
