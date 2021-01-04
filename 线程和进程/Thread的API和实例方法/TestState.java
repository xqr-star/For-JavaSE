package Bilibili.state;

//观察测试线程的状态
public class TestState {
    public static void main(String[] args) throws InterruptedException {

        /*//线程的状态是一个枚举类型Thread.State
        for(Thread.State state : Thread.State.values()){
            System.out.println(state);
        }*/




        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////");
        });


        //观察状态
        Thread.State state = thread.getState();//alt+enter 可以创建变量
        System.out.println(state);//new



        //观察启动后
        thread.start();
        System.out.println(thread.getState());

        while (thread.getState() != Thread.State.TERMINATED) { // 只要线程不终止就一直输出下去
            Thread.sleep(100);
            state = thread.getState(); // 更新线程状态
            System.out.println(state);
        }

        //线程中断或者结束后，一旦进入死亡状态就不能再次启动
        // 一个线程不能启动该两次，死亡以后就不能再启动了
        thread.start();


    }
}
