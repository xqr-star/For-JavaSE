package Bilibili.syn;


//第一中式拿着镜子的时候，还要拿口红
//第二种式是拿完镜子，就把镜子放下了 采取拿口红
public class DealDeadLock {
    public static void main(String[] args) {

        //分别执行线程，做的是不同的事情
        MakeUp g1 = new MakeUp(0,"灰姑娘");
        MakeUp g2 = new MakeUp(1,"白雪公主");
        g1.start();
        g2.start();
    }
}

//口红
class Lipstick{
}
//镜子
class Mirror{
}

//化妆
class MakeUp extends  Thread{

    //需要的资源只有一份，用static 来保证
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice; // 选择
    String girlName; // 使用化妆品的人
    public  MakeUp (int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //别忘记把makeUp 放进去，别粗心
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //化妆
    }

    //化妆，互相持有对方的锁，就是需要对方的资源
    private void makeUp() throws InterruptedException {

        if(choice == 0) {
            synchronized (lipstick){ // 获得口红的锁

                //注意这里为什么可以写this 是因为我继承了thread 类

                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);//每个对象都有一把锁，sleep 不会释放锁--很重要很重要
                //他说分开写的话，sleep的时间一到就会解锁了
            }
            synchronized (mirror){ // 一秒中之后想获得镜子的锁
                System.out.println(this.girlName+"想获得口红的 锁");
            }
        }else {
            synchronized (mirror){ // 获得口红的锁

                //注意这里为什么可以写this 是因为我继承了thread 类

                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(2000);
            }
            synchronized (lipstick){ // 一秒中之后想获得镜子的锁
                System.out.println(this.girlName+"想获得口红的锁");
            }

        }
    }



}
