package lesson2;

public class ThreadTest {
    public static void main(String[] args) {
        for(int i = 0; i <20 ;i++) {
            final int n = i; // 内部类使用外部的变量必须是final 修饰 和JVM 有关

            //子线程休眠三秒之后，无序运行
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1); // 休眠3秒
                        System.out.println(n);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();// 由系统决定什么时候转变为运行态
        }
        System.out.println("ok");

    }
}
