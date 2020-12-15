package lesson2;

public class ThreadTest2 {
    public static void main(String[] args) {
        for(int i = 0; i <20 ;i++) {
            final int n = i; // 内部类使用外部的变量必须是final 修饰 和JVM 有关

            //子线程休眠三秒之后，无序运行
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(n);
                }
            });
            t.start();
        }

        System.out.println("ok");

    }
 }



