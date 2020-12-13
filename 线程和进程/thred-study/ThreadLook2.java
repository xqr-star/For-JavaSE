package T1;

public class ThreadLook2 {
    public static void main(String[] args) {
        //第一中创建线程的方法
        //启动这个线程的时候，看不到main 线程 -- ？
        //只有t 线程在走
        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){

                }
            }
        };
        t.start();//线程启动
    }
}
