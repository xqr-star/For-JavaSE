package bite.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class phantomReferenceTest {
    public static void main(String[] args) {
        Object obj1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj1,referenceQueue);

        System.out.println(obj1);
        System.out.println(phantomReference.get());//null
        System.out.println(referenceQueue.poll());//null

        System.out.println("GC后");

        obj1 = null;
        System.gc();

        System.out.println(obj1);
        System.out.println(phantomReference.get());//null
        System.out.println(referenceQueue.poll());//java.lang.ref.PhantomReference@4554617c
    }
}
