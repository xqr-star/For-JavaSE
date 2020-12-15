package lesson2;

public class InterruptedTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //静态方法调用
                //返回当前线程t 的中断标志位  然后重置为false
                for (int i = 0; i < 10000 ; i++) {
                    System.out.println(i + ": "+ Thread.interrupted());
                }

            }
        });

        t.start(); // 线程启动中断标志位=false
        System.out.println("t start");
        //让t 线程中断掉 停止
        // 告诉t 线程要中断了(设置t 线程的中断标志位为true)，告诉了以后由t 的代码自行决定是否中断
        //如果t线程处于阻塞状态会抛出InterruptedException , 并且重置中断标志
        t.interrupt();
        System.out.println("t stop");

    }
}
