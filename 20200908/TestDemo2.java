import java.util.Scanner;

public class TestDemo2 {

    /**
     *青蛙跳台阶--斐波那契数列升级版
     * @param
     */
    public static int jump(int n) {
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        return jump(n-1)+jump(n-2);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret=jump(n);
        System.out.println(ret);
    }


    /**
     * 求斐波那契数列
     * 1 1 2 3 5 8 13 21 34
     * @param
     */
    //递归实现
    public static int fib(int num) {
      if(num == 1 || num == 2) {
          return 1;
      }
      return fib(num-1)+fib(num-2);
    }

    //迭代实现 举例：在迭代到第45 个斐波那契数列的时候
    //递归等待的时间比较长  迭代的效率提神
    //主要是递归层次太深了。
//    public static int fib(int num) {
//        if(num==1 || num==2) {
//            return 1;
//        }
//        int a = 1;
//        int b = 1;
//        int c = 0;
//        for (int i = 3; i <= num; i++) {
//            c = a + b;
//            a = b;
//            b = c;
//        }
//       return c;
//    }

    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int ret = fib(num);
        System.out.println(ret);
    }

    /**
     * 输入一个非负的整数，返回组成它的数字的和
     * 1792 1+7+9+2
     */
    public static int sumNumber (int num) {
        if(num<10) {
            return num;
        }
        return sumNumber(num/10) + num % 10;
    }
    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int ret = sumNumber(num);
        System.out.println(ret);
    }

    /**
     * 递归求1+2+3+..+10
     * @param
     */
    public static int sum(int num) {
        if(num == 1){
            return 1;
        }
        return num+sum(num-1);
    }
    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int ret = sum(num);
        System.out.println(ret);
    }

    /**
     * 按照顺序打印出1234
     * @param
     */
    //方法二：
    public static void print(int num) {
        if(num>9) {
            print(num/10);
        }
        System.out.println(num%10);
    }

//方法一：
//    public static void print(int num) {
//        if(num<9) {
//            System.out.println(num);
//        }
//        else {
//            print(num / 10);
//            System.out.println(num % 10);
//        }
//    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        //1234
        print(num);
    }

    /**
     * 递归求N的阶乘
     */
    public static int fib1(int num) {
        if(num == 1) {
            return 1;
        }
        else{
            return num*fib1(num-1);
        }

    }
    public static void main1(String[] args) {
        Scanner scan =new Scanner(System.in);
        int num=scan.nextInt();
        int ret=fib1(num);
        System.out.println(ret);
    }
}
