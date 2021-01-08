package lesson3;

/**
 * 有一个教室，座位有50个，同时有三个老师安排同学座位
 * 每个老师安排100个同学到达教室，模拟多线程实现
 * 三个线程同时启动安排同学
 * 同学循环操作来安排，直到座位满
 */
public class Practice {
    public static void main(String[] args) {
        Room room = new Room();

        Teacher teacher = new Teacher(room);


        //同时操作同一个资源
        new Thread(teacher,"Teacher1").start();
        new Thread(teacher,"Teacher2").start();
        new Thread(teacher,"Teacher3").start();

    }
}

//教室的座位
class Room{
    int seat = 50;
}
class Teacher implements Runnable{
    private Room room;

    public Teacher(Room room){
        this.room = room;
    }

    //每一个线程做的事情--安排100个学生抢座位
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                synchronized (Teacher.class){
                    if(room.seat > 0) {
                        System.out.println(Thread.currentThread().getName()+"已经安排了第"+room.seat--+"个座位");
                    }else {
                        return;
                    }
                }
              Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//如何在保证线程安全的同时，不要让一个线程抢占所有资源呢？