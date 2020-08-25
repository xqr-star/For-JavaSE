import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {
    //奇数位于偶数之前 调整数组顺序使得奇数位于偶数之前。
    // 调整之后，不关心大小顺序。
    public static void main(String[] args) {
        int []arr={22,34,56,1,3,8};
        System.out.println(Arrays.toString(arr));
        int left=0;
        int right=arr.length-1;
        while (left<right) {
            if(arr[left]%2 ==0 ) {
                if (arr[right] % 2 != 0) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                } else {
                    right--;
                }
            }else {
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    
    public static void main6(String[] args) {
        int []arr={22,34,56,1,3,9};
        System.out.println(Arrays.toString(arr));
        int left=0;
        int right=arr.length-1;
        while (left<right) {
           if(arr[left]%2 !=0) {
               left++;
           }
           if(arr[right]%2 ==0){
               right--;
           }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;right--;
        }
        System.out.println(Arrays.toString(arr));

    }


    //求阶乘和 求1！+2！+3！+4！+........+n!的和
    public  static int ficSum(int num) {
        int sum=0;
        for(int i=1;i<=num;i++) {
            sum+= fic(i);
        }
        return sum;
    }

    public static int fic(int num) {
        int ret=1;
        for(int i=1; i<=num;i++) {
            ret*=i;
        }
        return ret;
    }
    public static void main5(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入求第几个数字的阶乘");
        int num=scanner.nextInt();
        System.out.println(fic(num));
        System.out.println("请输入求第几个数字的阶乘和");
        int numSum=scanner.nextInt();
        System.out.println(ficSum(num));

    }


    //斐波那契
    //递归
    public static int fib(int num) {

        if(num==1 || num==2) {
           return 1;
        }else {
            return fib(num-1)+fib(num-2);
        }
    }
    public static void main4(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入求第几个斐波那契数列");
        int num=scanner.nextInt();
        System.out.println(fib(num));

    }

    //迭代
    //  1 1 2 3 5 8 13
    public static void main3(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入求第几个斐波那契数列");
        int num=scanner.nextInt();
        int a=1;
        int b=1;
        int c=a+b;
        if(num==1 || num==2) {
            System.out.println("1");
        } else {
            for(int i=3;i<=num;i++){
                c=a+b;
                a=b;
                b=c;
            }
            System.out.println(c);
        }
    }

    public static void main2(String[] args) {
        //找出出现一次的数字
        int[]arr={3,20,40,60,35,60,40,3,20};
        int num=0;
        for(int i=0;i<arr.length;i++) {
            num=num ^ arr[i];
        }
        System.out.println(num);
    }
    public static void main1(String[] args) {
       // Byte a=130;
        float b=3.0f;
    }
}
