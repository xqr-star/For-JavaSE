import java.util.Scanner;

public class TestDemo {
    //循环scanner 然后退出
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=0;
        while (scanner.hasNextInt()) {
            a=scanner.nextInt();
            System.out.println(a);

        }

    }

    //next nextLine
    public static void main4(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter your name");
        String str=scanner.next();
        System.out.println(str);

        System.out.println("age");
        int age=scanner.nextInt();
        System.out.println(age);

        System.out.println("work");
        String work=scanner.next();
        System.out.println(work);
    }

    //1！+2！+3! +... +5!
    //方法1
    public static void main3(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int result=0;
        int sub = 1;
        for(int j=1;j<=num;j++) {
            sub *= j;
            result +=sub;
        }
        System.out.println(result);
    }

    //1！+2！+3! +... +5!
    //方法二
    public static void main2(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int result=0;
        for(int j=1;j<=num;j++) {
            int sub = 1;
            for (int i = 1; i <= j; i++) {
                sub *= i;
            }
            result +=sub;
        }
        System.out.println(result);
    }

    //5 的阶乘
    public static void main1(String[] args) {
        int a=5;
        int sub=1;
        for(int i=1;i<=a;i++) {
            sub *= i;
        }
        System.out.println(sub);
    }
}
