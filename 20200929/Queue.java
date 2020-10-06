package impl.stack;

import java.util.NoSuchElementException;

//仿造真正的Queue 接口，不用泛型
public interface Queue {

    //通过抛出异常
    //要想在接口中有实现前面加上default

    //插入永远返回true
    default  boolean add(Integer e) {
        if(offer(e) == false) {
            throw new IllegalStateException();
        }
        return true;
    }

    //查看队首不删除
    default  Integer element() {
        Integer e = peek();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    //删除
    default Integer remove() {
        Integer e = poll();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;

    }



    //通过特殊的返回值

    boolean offer(Integer e) ; // true 成功 false 失败

    //查看不删除
    Integer peek();   //返回null 代表队列是空的
    // 正常返回元素下标？？？？


    //删除
    Integer poll();



}
