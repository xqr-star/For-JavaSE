package bite.reference;

import java.lang.ref.WeakReference;

public class weakReferenceTest {
    public static void main(String[] args) {
        Object obj = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj);
        System.out.println(obj);
        System.out.println(weakReference.get());

        obj = null;
        System.gc();
        System.out.println("GC之后....");

        System.out.println(obj);
        System.out.println(weakReference.get());
    }
}
