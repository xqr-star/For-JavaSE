package Bilibili;

//模拟龟兔赛跑
public class RaceRabbitSleep  implements  Runnable{
    private static String winner; // static 保证唯一性 而不是final 是常量必须要赋值
    //静态变量不属于对象

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子") && i%10 ==0){
                // 但是我又不想让它每跑一步休息一次 跑十步休息一次
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            boolean flag = gameOver(i); // 拿兔子线程来说，兔子为为什么会结束程序，我获取的i是自己的i又不是乌龟的，我的i
            //在这应该是10 来着 ，flag 应该是flase
            if(flag == true){
                System.out.println(Thread.currentThread().getName()+"跑了---"+i+"步");
                break;  // 比赛结束，程序结束
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }
        //判断是否完成比赛
    }

    //判断是否完成比赛
    private boolean gameOver(int step){
        //判断是否有winner?
        if(winner != null) { // 已经存在胜利者了 // 这个就是两个线程的共享资源
            return true;
        }
        if(step >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("胜利者是"+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //赛道只有一个赛道
        RaceRabbitSleep race = new RaceRabbitSleep();

        //线程启动-- Runnable
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
 }




   /* 胜利者是乌龟
            兔子跑了23步
    兔子跑了24步
            乌龟跑了100步*/
//怎么解决这个问题

