package lesson6;
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
public class BrandShop {

    /**
     * 库存数量
     */
    private  static  int COUNT;


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
                    synchronized (BrandShop.class){    //要保证生产者和消费者是同一把锁
                        // 如果用Consumer.class 的 生产者也要一样写
                        if(COUNT == 0 || consumerCount > 900) { // 库存达到下限，不能继续消费，要阻塞等待
                            BrandShop.class.wait(); // 释放对象锁 同时通知synchronized 失败的线程唤醒竞争
                        }else { // 库存>0 允许消费
                            System.out.printf("消费者 %s 消费了一个面包\n",name);
                            consumerCount++;
                            COUNT--;
                            //通知由BrandShop.class.wait(); 这个代码进入阻塞的线程 比如会通知到生产者唤醒
                            BrandShop.class.notifyAll();//注意为什么写这行代码 以及为什么用all
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
                while (true){             //一直生产
                    synchronized (BrandShop.class){    //要保证生产者和消费者是同一把锁
                        if(COUNT +3 > 100 || this.producerCount <=0) { // 库存达到上限，不能继续生产，要阻塞等待
                            BrandShop.class.wait(); // 释放对象锁 同时通知synchronized 失败的线程唤醒竞争
                        }else { // 库存>0 允许消费
                            System.out.printf("生产者 %s 生产了3个面包\n",name);
                            COUNT+=3;
                            this.producerCount--;
                            //通知由BrandShop.class.wait(); 这个代码进入阻塞的线程 比如会通知到生产者唤醒
                            BrandShop.class.notifyAll();//注意为什么写这行代码 以及为什么用all
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

    public static void main(String[] args) {
        Thread[] consumers = new Thread[20]; // 20个消费者
        for(int i = 0;i <20 ;i ++) {
            consumers[i] = new Thread(new Consumer(String.valueOf(i)));
        }

        Thread[] producers = new Thread[10]; // 10个生产者
        for(int i = 0;i <10 ;i ++) {
            producers[i] = new Thread(new Producer(String.valueOf(i)));
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
