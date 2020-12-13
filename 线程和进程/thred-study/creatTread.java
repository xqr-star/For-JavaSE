package T1;

public class creatTread {
    public static void main(String[] args) {
        Runnable r = new Runnable() { // 传入线程对象的构造方法
            @Override
            public void run() {//线程运行态时，执行

            }
        };
        Thread t = new Thread(r,"main中的子线程1");
        t.start();

        //合并的代码
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();


        //runnable 接口只有一个方法，可以直接用lanbda 表达式
        new Thread(() -> {
            System.out.println("使用匿名类创建 Thread 子类对象");
        },"main中 的子线程2");
    }
}
