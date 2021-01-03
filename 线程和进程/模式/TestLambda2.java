package Bilibili.demo02;

interface ILove{
    void love(int a);
}
class Love implements ILove{
    @Override
    public void love(int a) {
        System.out.println("I Love You!"+a);
    }
}



public class TestLambda2 {

    //静态内部类
    static class Love2 implements ILove{
        @Override
        public void love(int a) {
            System.out.println("I Love You!"+a);
        }
    }
    public static void main(String[] args) {
        ILove iLove = new Love(); // 接口 new 它的实现类
       /* iLove.love(1);

        iLove = new Love2();//更改引用指向对象
        iLove.love(2);


        //局部内部类
        class Love3 implements ILove{
            @Override
            public void love(int a) {
                System.out.println("I Love You!"+a);
            }
        }
        iLove = new Love3();
        iLove.love(3);


        //匿名内部类-- 没有名字通过接口去实现
        // 懒得写的单独的哪个类和implements
        iLove = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("I Love You!"+a);
            }
        };
        iLove.love(4);

        //lambda  我就是连new类都懒得写
        iLove = (int a)-> {
            System.out.println("I Love You!"+a);
        };
        iLove.love(520);

        //简化 1 去掉参数类型
        iLove = (a)-> {
            System.out.println("I Love You!"+a);
        };
        iLove.love(521);*/

        //简化2 （）
        /*iLove = a-> {
            System.out.println("I Love You!"+a);
        };
        iLove.love(523);*/

        //简化3 去掉{} 的原因是代码只有一行

        iLove = a-> System.out.println("I Love You!"+a);

        iLove.love(524);


        //总结
        //lambda 表达式只能有一行代码的情况下才能简化称为一行
        //如果有多行，就得有代码块包裹{}

        //前提是接口必须是函数式接口-- 接口里面只能有一个接口

        //多个参数，也可以去掉参数类型 参数类型可以不同
        //要去的都必须都去掉，必须加（）
    }
}
