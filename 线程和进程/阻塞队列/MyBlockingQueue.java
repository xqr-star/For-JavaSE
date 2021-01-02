package lesson7;

/**
 * 为什么刚开始写的是线程不安全的呢
 * put take 方法不具有原子性  --三个方法都加上synchronized
 * 4个属性不具有可见性
 *
 * put操作存满了需要阻塞等待
 * take操作取空了需要阻塞等待
 * take
 * @param <T>
 */
public class MyBlockingQueue<T> {
    //底层实现可以用数组或者链表

    //定义数组保存元素 --数组实现循环队列
    //需要的属性
    private Object[] queue; // 为什么上面写的是T 下面不能写T 好像是涉及到一个什么类型擦除问题

    private int putIndex;  // 存放元素的索引 -- 默认是0 不用初始化
    private int takeIndex; //取元素的索引
    private int size; // 数组元素数量

    //需要初始化一下
    public MyBlockingQueue(int len) {
        queue = new Object[len];
    }


    //存放元素 T 类型 e element
    // 需要考虑： putIndex 已经到达数组最大的下标
    // size 达到数组的最大长度

    //作用在实例方法上的对象是对this 对象加锁
    public synchronized void put(T e) throws InterruptedException {
        //当我们阻塞等待到被唤醒并再次竞争成功到对象锁，恢复后往下执行的时候，条件可能会被其他线程修改，需要再次进行判断
        while (size == queue.length){
            this.wait();//或者直接写成wait();
            //throw new RuntimeException("超过最大长度");
        }
        queue[putIndex] = e; // 存放到数组中
        //putIndex++;
        //取模操作放到首位
        putIndex = (putIndex + 1)% queue.length;
        size++;
        notifyAll(); // 和this.notifyAll（）一样
    }
    //取元素
    public synchronized T take() throws InterruptedException {
        while (size == 0){
            wait();
            //throw new RuntimeException("数组里面没有元素");
        }
        T t = (T) queue[takeIndex]; // 为什么强制类型转换 你的数组类型是Object
        //t 的类型是T
        queue[takeIndex] = null; //为什么要置为空，直接让它的值覆盖不可以吗？
        //可以采用后面的值覆盖的方式，但是如果没有值取覆盖的话，数组显示是有问题的，所以
        //还是建议采用将值置为null
        takeIndex = (takeIndex+1)% queue.length;
        size--;
        notifyAll();
        return t;
    }

    public  synchronized int size (){
        return size;
    }

    public static void main(String[] args) {
        //MyBlockingQueue queue = new MyBlockingQueue(10);
        //不写成上面的样子
        //如果我不写成泛型，那意义是什么
        MyBlockingQueue <Integer> myBlockingQueue = new MyBlockingQueue<>(10);

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 1000; j++) {
                            myBlockingQueue.put(j);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        //这样写出来以后，发现线程根本存不下那么多的数字，
        //jconsole 命令查看发现三个线程都是put操作的阻塞状态




        //加上取的操作以后，会改变size 之后在put 那里的阻塞的线程就会结束 --
        //只是在后面的 take 方法里面唤醒了，但是不调用线程线程就结束了吗 ?为什么结束了呢？
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (;;) {
                            int i = myBlockingQueue.take();
                            System.out.println(Thread.currentThread().getName()+":"+i);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        /*for(int i =0;i <10;i++){
            myBlockingQueue.put(String.valueOf(i));
        }
        for(Object e : myBlockingQueue.queue){
            System.out.println(e);
        }*/



        /*System.out.println("更改操作完成以后：");
        myBlockingQueue.put("10");*/

       /* for(Object e : myBlockingQueue.queue){
            System.out.println(e);
        }*/
    }


}
