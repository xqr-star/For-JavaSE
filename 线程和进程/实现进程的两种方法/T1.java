public class T1 {

    static class Test
    {
        private int data;
        int result = 0;
        public void m()
        {
            result += 2;
            data += 2;
            System.out.println(result + " " + data);
            // 为什么我start 之后他不会输出内容，
            // 而是要等到所有的start执行完以后才最后打印
        }
    }

    static class ThreadExample extends Thread {
        private Test mv;
        //构造方法
        public ThreadExample(Test mv)
        {
            this.mv = mv;
        }
        public void run() {
            synchronized(mv)//表示每次只会有一个该类的对象执行该代码块
            {
                mv.m();
            }
        }
    }

    static class ThreadTest {
        public static void main(String args[])
        {
            Test mv = new Test();
            Thread t1 = new ThreadExample(mv);
            Thread t2 = new ThreadExample(mv);
            Thread t3 = new ThreadExample(mv);
            //代码运行的顺序不是我写代码的顺序
            //具体运行的顺序是要看io分配
            t1.start();//只是就绪状态
            t2.start();//只是就绪状态
            t3.start();//只是就绪状态
        }
    }
}
