package bite.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

public class weakTest {
    public static void main(String[] args) {
        myHashMap();
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer,String> weakMap = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "myHashMap";

        weakMap.put(key,value);
        System.out.println(weakMap); //{2=myHashMap}

        key = null;
        System.out.println(weakMap); //{2=myHashMap}

        //手动触发gc
        System.gc();

        //gc 之后  WeakHashMap 自动被回收
        System.out.println(weakMap); //{}
        System.out.println(weakMap.size()); //0
    }
    private static void myHashMap() {
        HashMap<Integer,String> hashMap = new HashMap<>();
        Integer key = new Integer(1);
        String value = "myHashMap";

        hashMap.put(key,value);
        System.out.println(hashMap); //{1=myHashMap}

        key = null;
        System.out.println(hashMap); //{1=myHashMap}

        //key设置为null 和hashMap里面的放的Node结点的key没有任何关系 ，所以map里面该有的元素还是会有

        System.gc();
        System.out.println(hashMap); //{1=myHashMap}
    }

}
