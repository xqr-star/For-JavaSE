package lesson3;

public class synchronizedTest {
    private static int COUNT = 0;

    public static void increment() {
        COUNT++;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (synchronizedTest.class) { // 是基于对象的加锁
                    increment();
                }
            }
        }).start();




        new Thread(new Runnable() {
            @Override
            public void run() {
                increment(); // 不是说把方法加锁
            }
        }).start();

    }
}
