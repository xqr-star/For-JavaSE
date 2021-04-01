package bite.Atomic;

public class CAS {
    private  static int count = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 200; i1++) {
                        //但是由于本身线程的任务并不是耗时的
                        //但是线程不断地在切换状态
                        //所以这样的做法并不好
                        synchronized (CAS.class) {
                            count++;
                        }
                    }
                }
            }).start();
        }

        while (Thread.activeCount() >1){
            Thread.yield();//main线程让步
        }
        System.out.println(count);
    }
}
