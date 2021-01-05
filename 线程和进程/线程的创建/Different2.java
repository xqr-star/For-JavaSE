package Bilibili.syn;

//在使用Thread继承类的方法时，创建两个线程，
// 各自运行，数据并不共享，各自运行20次循环。
//

public class Different2 {
    public static void main(String[] args) {

         ExtendThread thread1 = new ExtendThread();
         thread1.setName("张三");
         ExtendThread thread2 = new ExtendThread();
         thread2.setName("李四");
         thread1.start();
         thread2.start();
    }
}
class ExtendThread extends Thread {

    private int a = 0;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        for (int i = 0; i < 20; i++) {
            System.out.println("Thread--" + getName() + "--运行；a为：" + (a++));
        }
    }
}