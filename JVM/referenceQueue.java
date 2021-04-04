package bite.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class referenceQueue {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(obj, referenceQueue);

        System.out.println(obj);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        obj = null;
        System.gc();
        Thread.sleep(500);


        System.out.println("GC之后....");
        System.out.println(obj);//null
        System.out.println(weakReference.get());//null
        System.out.println(referenceQueue.poll());//java.lang.ref.WeakReference@4554617c


        System.out.println("GC2次之后....");
        System.out.println(obj);//null
        System.out.println(weakReference.get());//null
        System.out.println(referenceQueue.poll());//引用队列两次变为空//null

    }
}
