import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {
    /**
     * 无序数组中，出现次数超过长度一半的数字
     * 时间复杂度O(N^2)
     * 待优化
     */
    public static void main(String[] args) {
        int[]arr={1,2,2,2,2,3,4,5,2};
        int key=arr.length/2;
        for(int i=0;i<arr.length-1;i++) {
            int count=0;
            for(int j=0;j<arr.length-1;j++) {
                if(arr[i]==arr[j]) {
                    count++;
                }
            }
            if(count>=key) {
                System.out.println(arr[i]);
            }
        }
    }
    /**
     * 求一个数组中，前k个最小的数字
     */
    public static void main2(String[] args) {
        Scanner scan=new Scanner(System.in);
        int k=scan.nextInt();
        int[]arr={8,7,6,5,4};
        System.out.println(Arrays.toString(arr));

        //先冒泡排序
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-1-i-1;j++) {
                //为什么不写成j<arr.length-1-i-1
                //每一次排序之后的最后一个值都是最大的
                // 不用让j在指向最后一个了，所以不用在-1
                if(arr[j]>arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        //输出前 k个数字
        for(int i=0;i<k;i++) {
            System.out.print(arr[i]+" ");
        }

    }


    /**
     * 有序数组中，两个值相加为key，返回其下标
     * @param args
     */
    public static void main1(String[] args) {
        Scanner scan=new Scanner(System.in);
        int key=scan.nextInt();
        int[]arr={1,2,3,4,5,7,7,8};
        int left=0;
        int right=arr.length-1;
        while (left<=right) {
            if(arr[left]+arr[right]>key) {
                right--;
            }
            if(arr[left]+arr[right]<key) {
                left++;
            }
            if(arr[left]+arr[right]==key) {
                System.out.println("对应的下标分别为"+left+" "+right);
                break;
            }

        }

    }
}
