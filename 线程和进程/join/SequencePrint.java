package lesson6;

public class SequencePrint {


    //有三个线程 要求同时执行三个线程，打印顺序是 CBA
    //进阶作业 -- 通知的方式

    public static void main(String[] args) {
        Thread c = new Thread(new PrintTask("”C",null));
        Thread b = new Thread(new PrintTask("”B",c));
        Thread a = new Thread(new PrintTask("”A",b));
        a.start();
        b.start();
        c.start();
    }
    private static class PrintTask implements Runnable{

        private  String content;
        private Thread joinTask;

        public PrintTask(String content, Thread joinTask) {
            this.content = content;
            this.joinTask = joinTask;
        }

        @Override
        public void run() {
            try {
                if (joinTask != null) {
                    joinTask.join();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(content);
        }
    }
}
