package Bilibili.syn;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                //b
                synchronized (list){

                list.add(Thread.currentThread().getName());
                }

            }).start();
        }
        //为什么会出现线程不安全，有可能是因为两个线程被添加到同一个位置，元素覆盖掉了

        //他说可能线程还在运行，结果就打印出来了，所以等一等放大问题的发生性
        //但实际上没什么用
       //Thread.sleep(3000);

        //为什么不加sleep 可能出现的结果还不是10000
        //因为太快了 -- 我之前的只是start
        //有的还没轮到cpu调度就直接给我打印了当然不行  其实你确实做到了安全，只是你的main 线程早早都走完啦
        System.out.println(list.size());
    }

}
