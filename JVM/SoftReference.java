package bite.reference;

import java.lang.ref.SoftReference;

class SoftTest {
    public static void main(String[] args) {
        memoryEnough();
       // memoryNotEnough();

    }

    private static void memoryNotEnough() {
        //内存足够不回收
        Object obj1 = new Object();//强引用
        SoftReference<Object> softReference = new SoftReference<>(obj1);//弱引用
        obj1 = null;
        System.gc();
        try{
            byte[] arr = new byte[1024*1024*10];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("软引用：" + softReference.get());
        }
    }

    private static void memoryEnough() {
        //内存足够不回收
        Object obj1 = new Object();//强引用
        SoftReference<Object> softReference = new SoftReference<>(obj1);//弱引用
        obj1 = null;
        System.gc();
        System.out.println(obj1);
        System.out.println(softReference);
    }
}

