package impl.stack;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.NoSuchElementException;

public interface Deque extends Queue {

    /**
     * 注意Queue 和 Deque是接口，里面是不能有具体的方法实现的
     * 因为LinkedLlist 这个类实现了这个接口，所以在
     * 在类里面重写这些方法 然后猜可以用
     * 而现在只是模拟了接口里面有什么
     * 因为没有写实现类
     * 所以这些方法并不能用的
     * 终于搞懂了
     * @return
     */
    //下面这组方法通过抛出异常

    boolean addFirst();
    default  void addFirst(Integer e) {
        if(offerFirst(e) == false) {
            throw new IllegalStateException()
        }
    }

    default void getFirst() {
        Integer e = peekFirst();
        if(e == null) {
            throw new NoSuchElementException();
        }
    }

    default void removeFirst() {
        Integer e = poolFirst();
        if(e == null) {
            throw new NoSuchElementException()
        }
    }
    default  void addLast(Integer e) {
        if(offerLast(e) == false) {
            throw new IllegalStateException();
        }
    }


    //为什么没有参数呢？
    default void getLast() {
        Integer e = peekLast();
        if( e == null) {
            throw new NoSuchElementException();
        }
    }
    default void removeLast() {
        Integer e = poolLast();
        if( e == null) {
            throw new  NoSuchElementException();
        }
    }

    //下面这组方法 用过特殊返回值

    boolean offerFirst(Integer e);
    Integer peekFirst();
    Integer poolFirst();

    boolean offerLast(Integer e);
    Integer peekLast();
    Integer poolLast();



    //这组方法继承自queue
    default boolean offer (Integer e) {
        return offerLast(e);
    }
    default Integer peek() {
        return peekFirst();
    }
    default  Integer poll() {
        return poolFirst();
    }




}
