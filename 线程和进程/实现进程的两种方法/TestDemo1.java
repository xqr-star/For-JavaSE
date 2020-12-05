public class TestDemo1 {
    public static void main(String[] args) {
        for(int i = 0;i<10;i++) {
            //创建10个MyThread对象，
            MyThread myThread = new MyThread();
            myThread.start();//调用start方法启动线程
            //jvm 会自动调用run 方法
        }
    }
}

class MyThread extends Thread {
    @Override
    //重写父类的run 方法
    public void run() {
       //for(int i = 0;i <3 ;i++) {
           System.out.println(Thread.currentThread().getName()+"正在执行");
       //}
    }
}
