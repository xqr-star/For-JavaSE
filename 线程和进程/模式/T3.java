package bite;

public class  T3{

    public static void main(String[] args) {
        //Singleton singleton = new Singleton();  外面不能用

        //单例模式到底怎么使用是一个问题啊？


    }
}


class Singleton {
    /*手写单例模式-懒汉实现方式，必须满足多线程安全。*/
    private static  volatile Singleton INSTANCE  ; //  这是一个引用
    private Singleton(){};//私有的构造方法
    public   static  Singleton getINSTANCE(){
        if(INSTANCE == null){
            synchronized (Singleton.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}

