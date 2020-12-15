package lesson2;

public class JoinTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("t");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        //t.join() 无条件等待
       // t.join(1000); // 当前线程main 是限时等待，直到t线程执行完毕，或者给定的时间已经到了
        // 具体的时间看两个时间哪一个先到，到了之后先往后在
        // 先等 1 s 打印main 然后等3 s 打印t
        t.join(4000); // 先等待3 s 打印t 然后执行main
        //先等待t 执行完，系统调度t由就绪态转变为运行态 加上 t 的运行时间
        System.out.println("main");
    }
}
