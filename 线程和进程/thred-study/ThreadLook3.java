package T1;

public class ThreadLook3 {
    //做到main 和 thread 线程一起运行
    public static void main(String[] args) {
        //在main 线程中 new 了线程对象 （一个匿名内部类）
        Thread t = new Thread(){
            @Override
            public void run() {//线程进入运行态之后，开始执行
                while (true){

                }
            }
        };
        t.start();//线程启动-- 告诉系统调度本程序，但是具体什么时候执行看系统自己，程序决定不了
        //申请系统调度，线程有创建态转变成就绪态，具体什么时候变成运行态由系统决定

        while (true){//是main 线程做的事情 和run 里面的代码时并发和并行执行

        }
    }

}
