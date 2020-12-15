package lesson2;

public class T {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        //main 线程的状态  Runnable 是包含就绪态和执行态两种状态的表述
        while (true){

        }

      //  Thread.sleep(99999);  -- 一个main 线程 // 这是一个静态方法
    }
}
