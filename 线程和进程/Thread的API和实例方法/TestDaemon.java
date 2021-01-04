package Bilibili.state;

//测试守护线程

public class TestDaemon {

    //创建主线程
    public static void main(String[] args) {

        God god = new God();
        Thread threadGod = new Thread(god);
        threadGod.setDaemon(true); // 默认是false 表示是用户线程
        threadGod.start();
        You you = new You();
        Thread threadYou = new Thread(you);
        threadYou.start();

        //当用户线程执行完毕后，守护线程就会被结束，
        // 虚拟机不用等待守护线程运行完毕
    }

}

//上帝

class  God implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}
//你

class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你在开心的活着");
        }
        System.out.println("====GoodBye World!====");
    }
}
