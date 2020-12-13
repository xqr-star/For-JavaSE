package T1;

public class ThreadLook4 {

    public static void main(String[] args) {
        //要同时启动20个线程，每个线程一次+1 从0 - 9999

        for (int i = 0;i < 20 ; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {//线程进入运行态之后，开始执行
                    //在多线程环境下，即使时同一个代码块，也是可以并发并行执行
                    int count = 0;
                    for(int i = 0 ; i < 10000; i++) {
                        if(i == 9999) {
                            System.out.println(i);
                        }
                    }
                }
            };
            t.start();
        }


//        Thread t = new Thread(){
//            @Override
//            public void run() {//线程进入运行态之后，开始执行
//                int count = 0;
//                for(int i = 0 ; i <=3; i++){
//                    count += i;
//                }
//                System.out.println(count);
//            }
//        };
//
//        //不能重复启动start 方法
//        for(int i = 0;i<20;i++){
//            t.start();
//        }

    }
}
