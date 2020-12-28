package lesson5;

public class Singleton {
    private static volatile Singleton INSTANCE ; //大写
    private Singleton() {}
    public synchronized static Singleton getInstance() {
        if (INSTANCE == null) {  // 保证性能 不是null 的时候可以直接return  不用再去加锁解锁耗时操作
            synchronized (Singleton.class) { // 同一个类操作加锁  这行代码不算加锁操作竞争对象锁，成功就进去执行，失败就阻塞态
                if(INSTANCE == null) {  //再次判断保证安全性  如果不加这个另一个线程之前判断的instance == null
                                         // 但是抢锁失败，之后竞争成功之后，会再次进行new 对象的操作，不满足单例模式只使用同一个对象
                    INSTANCE = new Singleton(); // 非原子性的new 操作
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i = 0; i<20 ;i ++){
            Singleton s = Singleton.getInstance();
        }
    }
}
