package Bilibili;

//多个线程同时操作一个对象
//买火车票
public class Thread4 implements Runnable {

    //票数
    private int ticketNums = 1000;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                if (ticketNums <= 0) {
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "票");

            }
        }

    }

    public static void main(String[] args) {
        Thread4 ticket = new Thread4();



        /*Thread t1 = new Thread(ticket, "乘客1");
        Thread t2 = new Thread(ticket, "乘客2");
        Thread t3=  new Thread(ticket, "乘客3");
        t1.start();
        t2.start();
        t3.start();*/

    }
}

//发现问题  多个线程操作同一个资源的情况下，线程不安全，数据紊乱

//不给他们加synchronized 之前
/* 乘客2拿到了第7票
乘客3拿到了第7票
乘客2拿到了第-1票*/
