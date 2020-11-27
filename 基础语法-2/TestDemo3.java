package select;

public class TestDemo3 {

    static class Test {
        public static void hello() {
            System.out.println("hello");
        }
        public void fun(){

        }
    }

    public static class MyApplication {
        public static void main(String[] args) {

            Test test = null;
            test.hello();
            test.fun();//调用静态内部类里面的非静态方法--先new 对象，通过这个对象调用方法

            Test.hello();

        }
    }
}
