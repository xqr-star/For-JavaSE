import java.util.Arrays;

public class TestDemo {

    /**
     * 方法的重载
     * 方法名必须相同 参数列表不同（及个数和类型）
     * 返回值不做要求
     */
    public static int add(int a,int b) {
        return a+b;
    }
    public static double add(double a,double b) {
        return a+b;
    }
    public static int add(int a,int b,int e) {
        int temp=add(a,b);
        return add(temp,e);
    }
    public static void main3(String[] args) {

        int a=10;
        int b=20;
        int ret1=add(a,b);
        System.out.println(ret1);
        double c=1.0;
        double d=2.4;
        double ret2=add(c,d);
        System.out.println(ret2);
        int e=4;
        int ret3=add(a,b,e);
        System.out.println(ret3);


    }
    /**
     * 交换两个整型变量
     */
    public static void swap(int[]arr) {
        int temp=arr[0];
        arr[0]=arr[1];
        arr[1]=temp;
    }
    public static void main2(String[] args) {
       int arr[]={10,20};
       System.out.println(Arrays.toString(arr));
       swap(arr);
       System.out.println(Arrays.toString(arr));
    }


    /**
     * 计算1！+2！+...+5!
     * @param args
     */
    public static void main1(String[] args) {

        //计算一个数的阶乘
        int num=5;
        int j=1;
        int sum=0;
        int ret=1;
        for(;j<=num;j++){
            //计算一个数的阶乘
            ret=1;
            for(int i=j;i>0;i--) {
                ret*=i;
            }
            //阶乘相加
            sum+=ret;
        }
        System.out.println(sum);

    }
}
