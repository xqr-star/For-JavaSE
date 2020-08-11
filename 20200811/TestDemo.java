public class TestDemo {

    public static void main(String[] args) {
        int num1 =10;
        int $num=20;
        int _num=30;
        String studentName="张三";
    }

    public static void main10(String[] args) {
        String a="hello";
        String b="world";
        String c="！";
        int d=10;
        int e=20;

        System.out.println(a+b+c);
        System.out.println(d+e);
        System.out.println(a+d+e);


    }
    public static void main9(String[] args) {
        boolean a=false;
        boolean b= true;
    }

    public static void main8(String[] args) {
        short a=10;
        short b=20;
        short c=(short) (a+b);
        System.out.println(c);
    }

    public static void main7(String[] args) {
        byte a=10;
        byte b=20;
        byte c=  (byte)(a+b);
        System.out.println(c);

    }

    public static void main6(String[] args) {
        char a= 'd';
        System.out.println(a);
        char b='往';
        System.out.println(b);
    }

    public static void main5(String[] args) {
        float a=1.0f;
        System.out.println(a);
    }

    public static void main4(String[] args) {
        double num=1.0;
        System.out.println(num);

        int a=10;
        int b=5;
        System.out.println(a/b);

        double c=10;
        double d=5;
        System.out.println(c/d);
        System.out.println(Double.MAX_VALUE);
    }

    public static void main3(String[] args) {
        long num=10L;
        System.out.println(num);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
    }

    public static void main2(String[] args) {
        int a=10;
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MIN_VALUE-1);
    }

    public static void main1(String[] args) {
        int num=10;
        int a=20;
        System.out.print(a);
        System.out.println(num);
        System.out.println("a的值"+a);
        System.out.printf("%d",a);
    }
}
