package Bilibili.demo02;

//静态代理模式
//真实对象 -- 目标对象  和代理对象都要实现同一个接口
//代理对象要代理真实角色，所以


//好处
//代理对象可以做很多真实对象做不了的事情
//真实对可以专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        you.HappyMarry();// 你要结婚

        //代理真实的实现Runnable接口

        new Thread( ()-> System.out.println("我在写代码")).start();

        new WeddingCompany(new You()).HappyMarry();

        WeddingCompany weddingCompany =  new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }

}

//结婚这个行为
interface Marry{
    //人间四大喜事 -- 久旱逢甘雨 他乡遇故知 洞房花烛夜 金榜题名时
    void HappyMarry();
}
//真实角色 你去结婚
class You implements  Marry{

    //实现接口，重写接口里面的方法
    @Override
    public void HappyMarry() {
        System.out.println("target 要结婚了");
    }
}
//婚庆公司 -- 代理角色帮助你结婚
class WeddingCompany implements Marry{

    // 持有代理角色的引用
    private Marry target; // 代理真实角色--目标结婚对象  返回类型可以是一个接口--引用数据类型

    //表示target 结婚  //传入一个真实角色
    public WeddingCompany(Marry target) {    //   public Thread(Runnable target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before(); // 这是我代理你做的很多事情
        this.target.HappyMarry(); // 表示目标对象结婚 -- 真实角色去结婚
        after();
    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }

    private void before() {
        System.out.println("结婚之前布置现场");
    }
}