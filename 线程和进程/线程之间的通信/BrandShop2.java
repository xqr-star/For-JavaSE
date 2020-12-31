package lesson6;

public class BrandShop2 {

//面包店升级版需求
    /**
     * 目前是一直不停的生产
     * 10个生产者 ： 每个每次生产3个
     * 20个消费者：每个每次消费1个
     * 升级版需求：
     * 面包师傅每个人最多生产30次
     * 消费者不再一直消费，把900个消费完就结束
     *
     * 隐藏信息：面包店总产最大数量： 10 * 30 *3 = 900 所以消费者把900个消费完就结束
     */

    private static  int MAX_STACK = 100;

    /**
     * 库存数量
     */
    private  static  int COUNT;//


    /**
     * 消费者数量
     */
    private static int CONSUMER_NUMBER = 10;

    /**
     * 消费者每次消费的面包数
     */
    private static int CONSUMER_COUNT = 5;
    /**
     * 生产者数量
     */
    private static int PRODUCER_NUM= 5;
    /**
     * 生产者的生产次数
     */
    private static int PRODUCER_TIMES = 10;

    /**
     * 每次生产的面包数
     */
    private static  int PRODUCE_COUNT = 3;


    /**
     * 面包店生产面包总数 ，不会消费
     */
    private static int PRODUCER_NUMBER = 0 ;

    //静态内部类
    public static class Consumer implements  Runnable{
        private  static int consumerCount; // 消费数量

        //生成名字
        private String name;
        //构造方法
        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while (true){             //一直消费
                    synchronized (lesson6.BrandShop.class){    //要保证生产者和消费者是同一把锁
                        // 如果用Consumer.class 的 生产者也要一样写
                        if(PRODUCER_NUMBER  == PRODUCER_NUM *PRODUCE_COUNT * PRODUCER_TIMES){
                            break;
                        }
                        if(COUNT - CONSUMER_COUNT < 0 ) { // 库存达到下限，不能继续消费，要阻塞等待
                            lesson6.BrandShop.class.wait(); // 释放对象锁 同时通知synchronized 失败的线程唤醒竞争
                        }else { // 库存>0 允许消费
                            System.out.printf("消费者 %s 消费了 %s 个面包，库存%s\n",name,CONSUMER_COUNT,COUNT);
                            CONSUMER_COUNT-=  CONSUMER_COUNT; // 消费者每次消费的面包数
                            //通知由BrandShop.class.wait(); 这个代码进入阻塞的线程 比如会通知到生产者唤醒
                            BrandShop2.class.notifyAll();//注意为什么写这行代码 以及为什么用all
                            Thread.sleep(500);
                        }
                    }
                    Thread.sleep(100); // 写这个休眠涉及到JDK优化
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Producer implements  Runnable{

        //private static int producerCount = 2; // 生产次数 -- 但是这里控制的是所有的生产次数，不是一个线程的执行个数

        private  int producerCount = 30;
        private String name;
        //构造方法
        public Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                //达到生产次数 一直生产
               for(int i = 0 ;i < PRODUCER_TIMES ; i++) {           //一直生产
                    synchronized (BrandShop2.class){    //要保证生产者和消费者是同一把锁
                        while(COUNT +PRODUCE_COUNT > MAX_STACK ) { // 库存达到上限，不能继续生产，要阻塞等待
                            BrandShop2.class.wait(); // 释放对象锁 同时通知synchronized 失败的线程唤醒竞争
                        }   // 库存>0 允许消费
                            System.out.printf("生产者 %s 生产了 %s 次,库存 %s ，生产的数量%s\n",name,i+1,COUNT,PRODUCER_NUMBER);
                            COUNT+=PRODUCE_COUNT;
                            PRODUCER_NUMBER += PRODUCE_COUNT ;
                            //通知由BrandShop.class.wait(); 这个代码进入阻塞的线程 比如会通知到生产者唤醒
                            BrandShop2.class.notifyAll();//注意为什么写这行代码 以及为什么用all
                            Thread.sleep(500);
                    }
                    Thread.sleep(100); // 写这个休眠涉及到JDK优化
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] consumers = new Thread[CONSUMER_NUMBER]; // 20个消费者
        for(int i = 0;i <CONSUMER_NUMBER ;i ++) {
            consumers[i] = new Thread(new lesson6.BrandShop.Consumer(String.valueOf(i)));
        }

        Thread[] producers = new Thread[PRODUCER_NUM]; // 10个生产者
        for(int i = 0;i <PRODUCER_NUM ;i ++) {
            producers[i] = new Thread(new lesson6.BrandShop.Producer(String.valueOf(i)));
        }


        for(Thread t: consumers){
            t.start();
        }

        for(Thread t: producers){
            t.start();
        }


//        Thread threads[] = new Thread[20];
//        Consumer consumer = new Consumer();
//        for(int i = 0 ;i < 20;i++){
//            threads[i] = new Thread(consumer); // ???
//        }
//        for(Thread t : threads) {
//            t.start();
//        }

    }
}


