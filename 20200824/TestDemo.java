import java.util.Random;
import java.util.Scanner;

public class TestDemo {
    
    //猜数字游戏
    public static void main20(String[] args) {
        Random random=new Random();//默认随机种子是系统时间
        int key=random.nextInt(100)+1;//【0-100） +1=【0-101）

        Scanner scanner =new Scanner(System.in);
        while (true) {
            System.out.println("请输入要猜的数字");
            int num=scanner.nextInt();
            if(num == key) {
                System.out.println("猜对了");
                break;
            } else if(num > key) {
                System.out.println("猜大了");
            } else {
                System.out.println("猜小了");
            }

        }

    }



    //获取二进制序列中的偶数和奇数位
    public static void main19(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        int temp=num;
        //奇数位
        int i=30;
        System.out.println("奇数位：");
        while (i>0){
            System.out.print( (num>>i)&1 );
            i-=2;
        }
        System.out.println();

        System.out.println("偶数位：");
        i=31;
        num=temp;
        while (i>0){
            System.out.print( (num>>i)&1 );
            i-=2;
        }
    }

    //1的个数
    public static void main18(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        int count=0;
        while (num!=0) {
           num = num&(num-1);
           count++;
        }
        System.out.println(count);
    }
    public static void main17(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        int i=0;
        int count=0;
        while (i<31){
           if( ((num>>i) & 1)== 1){
               count++;
           }
           i++;
        }
        System.out.println(count);
    }
    //整数的每一位
    //顺序
    public static  int printf(int num){
        if(num>0 && num<10) {
            System.out.println(num);
        } else{
            printf(num/10);
            System.out.println(num%10);
        }
        return 0;
    }
    public static void main16(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        printf(num);
    }

    //
    public static void main15(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        while (num != 0){
            System.out.println(num%10);
            num=num/10;
        }

    }
    //模拟登录场景
    public static void main14(String[] args) {
        Scanner scan= new Scanner(System.in);
        int count=3;
        while (count!=0) {
            System.out.println("请输入：");
            String str=scan.nextLine();
            if (str.equals("123") == true) {
                System.out.println("恭喜你，输入正确");
                break;
            } else {
                count--;
                System.out.println("输入错误，你还有" + count + "次机会");
            }
        }
    }

    //0-999 所有的水仙花数
    public static void main13(String[] args) {
        for(int i=0;i<1000;i++) {
            //计算位数
            int num=i;
            int count=0;
            while(num != 0){
                count++;
                num = num/10;
            }
            //每一位之和
            num = i;
            int sum = 0;
            while (num != 0){
                sum +=Math.pow(num%10,count);
                num = num/10;
            }
            if(sum == i){
                System.out.println(sum);
            }
        }
    }

    //1-100 多少个数字9
    public static void main12(String[] args) {
        int count=0;
        for(int i=1;i<=100;i++) {
            if(i%10==9) {
                count++;
            }
            if(i/10==9) {
                count++;
            }
        }
        System.out.println(count);
    }
    //计算1/1- 1/2 +1/3 - .... -1/100
    public static void main11(String[] args) {
        double ret=0.0;
        int flag=1;
        for(int i=1;i<=100;i++) {
            ret+=1.0/i*flag;
            flag=-flag;
        }
        System.out.println(ret);
    }

    //最小公倍数
    //最小公倍数=两整数的乘积÷最大公约数 反之同理。
    public static void main10(String[] args) {
        int a = 24;
        int b = 18;
        int sum = a*b;
        while(a!=b){
            if(a>b) {
                a=a-b;
            } else if(a<b) {
                b=b-a;
            }
        }
        int ret = sum/b;
        System.out.println("最小公倍数"+ret);

    }


    //最大公约数
    //更相减损法
    public static void main9(String[] args) {
        int a = 24;
        int b = 18;
        while(a!=b){
            if(a>b) {
                a=a-b;
            } else if(a<b) {
                b=b-a;
            }
        }
        System.out.println("最大公约数是"+b);
    }
    //辗转相除法
    //余数为0 除数就是最大公约数
    public static void main8(String[] args) {
        int a = 18;
        int b = 24;
        int c = a%b;
        while(c != 0){
            a = b;
            b = c;
            c = a%b;
        }
        System.out.println("最大公约数是"+b);


    }
    //运行时参数
    public static void main7(String[] args) {
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
        System.out.println("hhhh");
    }

    //乘法口诀表
    public static void main6(String[] args) {
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++) {
                System.out.print(i+"*"+j+"=" + i*j+" ");
            }
            System.out.println();
        }

    }
    //闰年
    public static void main5(String[] args) {
        int count=0;
        for(int i=1000;i<=2000;i++) {
            if(i%4==0 && i%100!=0 || i%400==0) {
                count++;
                System.out.println(i+"是闰年");
            }
        }
        System.out.println(count);
    }
    //素数
    public static void main4(String[] args) {
        for(int i=1;i<=100;i++){
            int j=2;
            for(;j<=Math.sqrt(i);j++){
                if(i % j == 0){
                    break;
                }
            }
            if(j>Math.sqrt(i)){
                System.out.println(i);
            }
        }
    }

    public static void main3(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        int i=2;
        for(;i<=num/2;i++){
            if(num % i == 0){
                break;
            }
        }
        if(i<=num/2){
            System.out.println(num +"不是素数");
        } else {
            System.out.println(num +"是素数");
        }
    }
    public static void main2(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        int i=2;
        for(;i<=Math.sqrt(num);i++){
            if(num % i == 0){
                break;
            }
        }
        if(i<=Math.sqrt(num)){
            System.out.println(num +"不是素数");
        } else {
            System.out.println(num +"是素数");
        }
    }
    //逻辑控制条件语句
    public static void main1(String[] args) {
        Scanner scan =new Scanner(System.in);
        int age=scan.nextInt();
        if(age<=0){
            System.out.println("输入无效");
        } else if(age>0 && age<=18) {
            System.out.println("少年");
        } else if(age>18 && age<=28){
            System.out.println("青年");
        } else if(age>28 && age<=55){
            System.out.println("中年");
        } else{
            System.out.println("老年");
        }

    }

}
