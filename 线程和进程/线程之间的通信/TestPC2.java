package Bilibili.gaoji;

//信号灯池法
/**
 * 之前的是两个线程都继承Thread 对象，然后里面传递的的是
 * 同一个资源，两个线程各自分别执行，互相不通信
 */

public class TestPC2 {

    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watch(tv).start();
    }
}

//生产者-演员
class Player extends Thread{
    Tv tv = new Tv();
    //构造方法
    public Player(Tv tv){
        this.tv = tv;
    }
    @Override
    public void run() {
        //20个小时
        for (int i = 0; i < 20; i++) {
            this.tv.play("快乐大本营");
        }
    }
}

//消费者-观众
class Watch extends Thread{
    Tv tv = new Tv();
    //构造方法
    public Watch(Tv tv){
        this.tv = tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//产品-节目
class  Tv{
    //演员表演，观众等待 T
    //观众观看，演员等待 F

    String voice ; //表演的节目
    boolean flag = true;//标志为true 表示可以开始表演节目


    //表演 -- 为什么要给这个代码加锁，又不会有其他线程来和我抢占确实不是因为线程的抢占
    //如果当前的线程不是此对象锁的所有者，却调用该对象的notify()，notify()，wait()方法时抛出该异常。
    public synchronized void play(String voice) {

        //之前有说不建议写成if 的样子---？
        if(!flag) {
            try {
                this.wait(); //这里的this 指的是谁，是什么？当前对象tv对象？是演员对象等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了"+voice);


        //通知观众观看
        this.notifyAll();//唤醒

       // this.voice = voice;//把节目更新一下
        this.flag = !this.flag;
    }


    //观看
    public synchronized void watch()  {
        if(flag) {
            try {
                this.wait();//建议写成while 就是等待之后，需要再次判断flag不然就是顺序往后执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了"+voice);

        //通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }



}