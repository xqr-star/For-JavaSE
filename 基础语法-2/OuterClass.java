package select;

public class OuterClass {

        // 静态方法，又称为类方法，属于Test类
        public static void staticFun() {
        }

        // 非静态方法，又称为实例方法，属于Test类的具体实例
        public void nonStaticFun() {
        }

        // 静态内部类，静态类只能是内部类
        public static class StaticInnerClass {

            // 静态方法，属于StaticInnerClass类
            public static void staticFun() {
            }

            // 非静态方法，属于StaticInnerClass类的实例
            public void nonStaticFun() {
            }
        }

        // 非静态内部类，不能有静态方法
        public class NonStaticInnerClass {

            // 非静态方法，属于NonStaticInnerClass的实例
            public void nonStaticFun() {
            }
        }

        // 测试代码如下：
        public static void main(String[] args) {
            // 对于静态方法，使用类直接访问
            OuterClass.staticFun();
            StaticInnerClass.staticFun();

            // 对于非静态方法，需要使用类的实例访问
            new OuterClass().nonStaticFun();//匿名类
            new StaticInnerClass().nonStaticFun();//静态内部类可以写非静态方法

            // 对于非静态内部类，必须创建外部类后才能使用
            OuterClass outerClass = new OuterClass();
            NonStaticInnerClass nonStaticInnerClass = outerClass.new NonStaticInnerClass();
            nonStaticInnerClass.nonStaticFun();
        }

}
