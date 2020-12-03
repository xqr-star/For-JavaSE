public class RunnableDemo implements Runnable {
    //public interface Runnable  内部只有一个run 方法

    @Override
    public void run() {
        for(int i = 0; i<2;i++) {
            System.out.println(Thread.currentThread().getName()+"正在运行");
        }
    }

    public static void main(String[] args) {
        for(int i =0 ;i< 3;i++) {
            RunnableDemo runnableDemo = new RunnableDemo();
            //需要将Runnable 包装成Thread 对象
            Thread t = new Thread(runnableDemo);
            //设置线程名称
            t.setName("runnable" + i);
            //启动线程
            t.start();

        }
    }
}
