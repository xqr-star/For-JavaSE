package lesson3;

public class SynchronizedTest2 {

    /**
     * 有一个教室，座位有50个，同时有三个老师安排同学座位
     * 每个老师安排100个同学到达教室，模拟多线程实现
     * 三个线程同时启动安排同学
     * 同学循环操作来安排，直到座位满
     */
    static class MyThread implements Runnable{
        private  int seat = 50;

        @Override
        public void run() {
            for(int i = 0 ;i<100;i ++){
                synchronized (this){
                    try{
                        if(this.seat > 0) { // 还有座位
                            seat--;
                            System.out.println(Thread.currentThread().getName() + "正在安排同学" +"还有"+seat+"座位");
                            Thread.sleep(200);
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread,"老师1");
        Thread t2 = new Thread(myThread,"老师2");
        Thread t3 = new Thread(myThread,"老师3");
        t1.start();
        t2.start();
        t3.start();

    }
}
//出现了一个老师安排了所有同学的情况
