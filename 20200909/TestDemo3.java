import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestDemo3 {
    //求二进制中1 的个数
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        int i=0;
        int count=0;
        while (i<=31) {
            if(( (num>>>i)&1 ) == 1) {
                count++;
            }
            i++;
        }
        System.out.println(count);
    }


    //奇数放在偶数的前面
    public static void main2(String[] args) {
        int[]arr={1,3,5,6,8};
        System.out.println(Arrays.toString(arr));
        int left=0;
        int right=arr.length-1;
        while (left<right) {
            if(arr[left]%2==0 ) {
                if(arr[right]%2!=0) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                right--;
            }
            left++;
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));


//        while(left<right) {
//            if(arr[left]%2!=0 ) {
//                left++;
//            }
//            if(arr[right]%2==0) {
//                right--;
//            }
//            int temp = arr[left];
//            arr[left] = arr[right];
//            arr[right] = temp;
//            System.out.println(Arrays.toString(arr));
//
//        }
//        System.out.println(Arrays.toString(arr));
    }

    public static void main1(String[] args) {
        int i=15;
        i=i++;
        System.out.println(i);
        i=++i;
        System.out.println(i);

        i=2;
        int j=i++ *3;
        System.out.println(j);

        i=2;
        j=++i*3;
        System.out.println(j);

    }
}
