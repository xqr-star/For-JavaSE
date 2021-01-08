package lesson3;

/**
 * 有一个教室，座位有50个，同时有三个老师安排同学座位
 * 每个老师安排100个同学到达教室，模拟多线程实现
 * 实现控制每个老师安排的学生数量
 */

public class Practice2 {
    public static void main(String[] args) {
        Room2 room2 = new Room2();
        //同时对room 进行操作，但是具体操作的个数有限制

        new Thread(new Teacher2(room2,10)).start();
        new Thread(new Teacher2(room2,10)).start();
        new Thread(new Teacher2(room2,30)).start();
    }

}
//教室的座位
class Room2{
    int seat = 50;
}

class Teacher2 implements Runnable{
    private Room2 room;
    private int  num;

    public Teacher2(Room2 room, int num) {
        this.room = room;
        this.num = num;
    }

    //每一个线程做的事情--安排100个学生抢座位
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (Room2.class){
                if(room.seat > 0 && num >0) {
                    System.out.print(Thread.currentThread().getName()+"已经安排了第"+room.seat--+"个座位");
                    System.out.println("这是他安排的第"+num--+"个座位");
                }else {
                    return;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}