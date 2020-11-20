package sort;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class insertSort {


    public static void insertSort(long[] arr) {
        //写成一个long 数组只是为了数据和下标区分开

        //想象打牌里面的插入排序
        //一共有的数据个数arr.length  //默认第一个是有序的
        //拿数字的操作次数 -- 循环length-1 次认为第一个数有序
        for(int i = 0;i<arr.length-1;i++) {

            //有序区间 [0 - i+1) [0 - i]
            //无序区间 [i+1 - arr.length) [0 - arr.length-1]
            //和有序区间的元素进行比较
            //抓出来的那张牌把它拿出来
            long key = arr[i+1];

            //依次在有序区间进行比较 -- 倒着比大小??有优势
            int j = i;
            for(;j >= 0; j--) {
                //arr[j] 就是需要和key 比较的数字
                if (key >= arr[j]) {
                    //直接放后面然后结束大小比较就好啦
                    break;
                } else {
                    //key < arr[j]
                    arr[j + 1] = arr[j]; //并不是说要把arr[j] 的位置变成key Key 还没找到它的位置呢！！
                }
            }
            //选择合适的位置插入
            //此时arr[j]的位置就是我要插入的位置啦
            //在把它放回去就好啦
            arr[j+1] = key;


            //----error 错在哪里 错在比arr[j]小之后
                //不能把arr[j] 放Key 你还没扎到正确的位置呢
//                if(key >= arr[j]) {
//                    arr[j+1] = key;
//                    break;
//                }else {
//                    arr[j+1] = arr[j];
//                    arr[j] = key;
//                }
//            }

        }
    }



    //测试
    //1 数据完全乱序
    //2 数据完全有序
    //3 数据逆序
    //4 完全相等、
    //5 测试不同规模额数据 1000 1万个 ....

    public static  long[] 构建随机数组() {
        Random random = new Random(20201020);
        //把随机种子确定以后，每次生成的数组都会是一样的 -- 构造方法里面的参数
        long [] arr = new long[10];
        for(int i = 0 ;i < 10; i++) {
            arr[i] =random.nextInt(100);
            //生成一个100 以内的数字
        }
        return  arr;
    }

    public static long[] 构建完全有序数组() {
        long [] array = 构建随机数组();
        Arrays.sort(array);//用数组内置的方法排序
        return array;
    }

    //你这个数组的交换逆序啊根本做不到使得整个数据完全有序啊！！
//    public static void swap(long[] arr) {
//        for(int i = 0;i < arr.length-1; i++) {
//            if(arr [i] >arr[i+1] ){
//                long temp = arr[i];
//                arr[i] = arr[i+1];
//                arr[i+1] = temp;
//            }
//        }
//    }
    public static void swap(long[] arr,int i ,int j) {
        long temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp;
    }

    public static long[] 构建完全逆序的数组() {
        long [] array = 构建完全有序数组();
        swap(array,0,9);
        swap(array,1,8);
        swap(array,2,7);
        swap(array,3,6);
        swap(array,4,5);
        //这个方法写的不行啊
//        //用一下交换的方法
//        swap(array);
        return array;
    }

    public static long[] 构建完全相等数组() {
        long[] array = new long[10];
        for(int i = 0;i < array.length; i++) {
            array[i] = 2;
        }
        return array;
    }
    public static void main(String[] args) {

        long [] a1 =  构建随机数组();
        System.out.println(Arrays.toString(a1));
        insertSort(a1);
        System.out.println(Arrays.toString(a1));

//        long[] a2 = 构建完全有序数组();
//        System.out.println(Arrays.toString(a2));
//        insertSort(a2);
//        System.out.println(Arrays.toString(a2));

//        long[] a3 = 构建完全逆序的数组();
//        System.out.println(Arrays.toString(a3));
//        insertSort(a3);
//        System.out.println(Arrays.toString(a3));

//        long[] a4 = 构建完全相等数组();
//        System.out.println(Arrays.toString(a4));
//        insertSort(a4);
//        System.out.println(Arrays.toString(a4));


    }



}
