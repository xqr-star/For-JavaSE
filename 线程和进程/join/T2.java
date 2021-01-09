package bite;

public class T2 {
    /**
     * 有三个线程，线程名称分别为：a，b，c。
     * 每个线程打印自己的名称。
     * 需要让他们同时启动，并按 c，b，a的顺序打印
     */
    public static void main(String[] args) {
        Thread thread3 = new Thread(new MyThread("c",null));
        Thread thread2 = new Thread(new MyThread("b",thread3)); // 表示再打印之前一定保证c先打印
        Thread thread1 = new Thread(new MyThread("a",thread2)); // 表示再a打印之前一定保证b先打印

        thread3.start();
        thread2.start();
        thread1.start();
    }
}

class MyThread implements Runnable{
    String name ;
    Thread thread;

    //构造方法不能写传这个引用MyThread，因为还没构造出来呢
    public MyThread(String name,Thread thread) {
        this.name = name;
        this.thread= thread;
    }


    @Override
    public void run() {
        try {
            //注意处理空指针异常
            if(thread != null){
                thread.join();//thread 线程先执行，当前线程让步
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name);
    }
}
