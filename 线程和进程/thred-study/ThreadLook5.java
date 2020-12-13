package T1;

public class ThreadLook5 {
    public static void main(String[] args) {
        // main 线程干的事情是 new 对象 和start 方法
        Thread t = new Thread() {
            @Override
            public void run() {//线程进入运行态之后，开始执行
                //在多线程环境下，即使时同一个代码块，也是可以并发并行执行
                int count = 0;
                for (int i = 0; i < 24; i++) {

                    // 线程中处理异常的方法  线程对象.setUncaughtExceptionHandler
                    //或者自己在run ()方法中捕获并处理
                    if(i == 20) // 某个线程抛异常如果是抛到run 方法(因为这里没有直接try catch、)，整个线程直接终止，但不会影响其他线程（不影响main线程）
                        throw new RuntimeException();
                    System.out.println(i);
                }
            }
        };
        t.start();

    }
}

