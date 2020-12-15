package lesson2;

public class JoinTest {

    // 不太使用yield 操作，使用join 的操作
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t");
            }
        });
        t.start();
        t.join(); // 当前线程即为 main 线程无条件等待，直到t线程执行完毕
        System.out.println("main");
    }
}
