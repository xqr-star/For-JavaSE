package lesson3;

public class Practice3 {

    private static  int seat = 50;

    public static void main(String[] args) {


        new Thread( new Teacher3(10)).start();
        new Thread( new Teacher3(20)).start();
        new Thread( new Teacher3(20)).start();
    }

    static class Teacher3 implements Runnable{

        private int  num;
        public Teacher3(int num) {
            this.num = num;
        }

        //每一个线程做的事情--安排100个学生抢座位
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (Practice3.class){ // Teacher3.class
                    if(seat > 0 && num >0) {
                        System.out.print(Thread.currentThread().getName()+"已经安排了第"+seat--+"个座位");
                        System.out.println("这是他安排的第"+num--+"个座位");
                    }else {
                        return;
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
