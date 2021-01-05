package Bilibili.syn;

//在使用Runnable实现类的方法中，a的值是两个线程共享的
// 每个线程运行20次，
// 但是线程中断的地方是不一定的，
// 所以有可能出现a线程运行++但是还没有运行输出结果就中断了，
// 然后b运行，所以就出现0在1前面了。
public class Different {
    public static void main(String[] args) {
        ImplementRunnable implementRunnable = new ImplementRunnable();

        new Thread(implementRunnable,"线程1").start();
        new Thread(implementRunnable,"线程2").start();

    }
}
 class ImplementRunnable implements Runnable {
    private int a = 0;
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Thread--" + Thread.currentThread().getName() + "--运行；a为：" + (a++));
        }
    }

}