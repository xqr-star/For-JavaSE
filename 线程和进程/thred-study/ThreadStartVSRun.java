package T1;

public class ThreadStartVSRun {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();//这里就是会出现两个线程 一个main 一个thread


        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).run(); // 只有一个线程就是main 没有thread 线程了
    }
}
