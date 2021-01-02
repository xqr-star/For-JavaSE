package lesson7;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5, // 核心线程数 -- > 正式员工
                10, // 最大线程数  --> 正式员工+临时员工
                60,
                TimeUnit.SECONDS, // idle 线程的空闲时间：--> 零时工最大的存活时间，超过时间就解雇
                new LinkedBlockingQueue<>(), // 阻塞队列--快递公司任务存放的地方 -- 快递仓库
                /*new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {

                        //创建线程
                        return new Thread(new Runnable() {
                            @Override
                            public void run() {
                                long start = System.currentTimeMillis(); // 获取当前时间

                                r.run();
                                long end  = System.currentTimeMillis(); // 获取当前时间

                                System.out.println("任务执行"+(end - start)+"时间");
                                // 报错是 - 不能用在字符串和long 之间 它把"任务执行"+end  当作一个字符串 然后 - 后面的是long 类型
                            }
                        });
                    }
                }, */// 创建线程的工厂类：线程池创建线程时，调用该工厂的方法创建线程 -->招聘员工的标准
                new ThreadPoolExecutor.AbortPolicy() //
                /**
                 * 拒绝策略--达到最大线程数和阻塞队列已经满，采取的拒绝策略
                 * AbortPolicy: 直接抛出RejectedExecutionException 不提供handler 的默认策略
                 * CallerRunsPolicy: 谁(某个线程)交给我任务，我拒绝执行，由谁自己执行 你发了快递给我 员工满了 仓库满了，你自己送
                 * DiscardPolicy:交给我的任务直接丢弃
                 * DiscardOldestPolicy :阻塞队列中最旧的任务  丢掉仓库里面存放最久的
                 *
                 *
                 *
                 */

        ); // 线程池创建以后，只要由任务就会自动给执行


        //20 个任务
        for (int i = 0; i < 20; i++) {
            //线程池执行任务 execute submit

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    //每个任务就是休眠一秒钟
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
}
