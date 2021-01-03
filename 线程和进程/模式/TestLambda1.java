package Bilibili.demo02;

/**
 * 推导lambda 接口表达式
 */

//1 定义一个函数式接口
interface  ILike{
    void lambda(); //  默认是public abstract
}
//2 实现类
class Like implements  ILike{
    @Override
    public void lambda() {
        System.out.println("我在学lambda");
    }
}

public class TestLambda1 {

    //3 静态内部类 -- 把实现类放到public 类里面
    static class Like2 implements  ILike{
        @Override
        public void lambda() {
            System.out.println("我在学lambda2");
        }
    }







    public static void main(String[] args) {
        ILike iLike = new Like() ; // 接口引用指向一个对象
        iLike.lambda();

        Like2 like2 = new Like2();
        like2.lambda();

        //4 局部内部类
        class Like3 implements  ILike{
            @Override
            public void lambda() {
                System.out.println("我在学lambda3");
            }
        }
        Like3 like3 =  new Like3();
        like3.lambda();

        //5 匿名内部类  没有类的名称，必须借助接口或者父类实现
        //前面的都是new 类，这里是new 一个接口
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("我在学lambda4");
            }
        };
        like4.lambda(); //写了匿名内部类之后，还需要调用

        //6 lambda 简化
        ILike like5 = ()-> {
            System.out.println("我在学lambda4");
        };
        like5.lambda();



    }

}
