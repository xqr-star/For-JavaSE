package bite.Atomic;


import java.util.concurrent.atomic.AtomicInteger;

//使用原子性的并发包 既满足安全又满足效率
//内部的实现方式都是Unsafe类,基于CAS+自旋来实现的
public class AtomicIntegerTest {


  private static AtomicInteger atomicInteger = new AtomicInteger();
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i1 = 0; i1 < 200; i1++) {
            //但是由于本身线程的任务并不是耗时的但是线程不断地在切换状态所以这样的做法并不好
            atomicInteger.incrementAndGet();

          }
        }
      }).start();
    }

    while (Thread.activeCount() >1){
      Thread.yield();//main线程让步
    }
    System.out.println(atomicInteger.get());
  }
}
