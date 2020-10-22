package sort;

public class bubbleSort {


    public static void bubbleSort(long[] arr) {
        //--冒泡过程自始至终不涉及对有序区间的操作


        //外层循环表示需要冒泡的过程
        /**
         * 用来表示当前第 i 趟是否有交换，
         * 如果有则要进行 i+1 趟，如果没有，
         * 则说明当前数组已经完成排序。实现代码如下：
         */
        for(int i = 0 ;i < arr.length-1;i++) {
            boolean isSorted = true;//优化，一开始假设是有序的


            //内层循环表示需要比较的趟数
            //无序区间
            // 把无序区间找出来 而且不能包含最后一个数因为要和后面的数字比较
            // 【0 - arr.length-i)  j < arr.length-i 是在有序区间里面
            // -1 是因为两两比较数组下标的界限的前一个
            //有序区间  【arr.length-i - arr.length)
            for(int j = 0 ; j < arr.length-i -1;j++) {
                if(arr[j] > arr[j+1]) {
                    long temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = false; //交换过就说明无序
                }

//                if(isSorted) {
//                    break;
//                }
                //--不能在这里错的原因 如果完全有序 我得保证从前往后走
                //完整走一遍 还是true才能说明真的有序
                //如果写在里面我一次完整的还没走完呢
                //只能保证前两个比较是有序的--point
            }

            //完整的一次冒泡走完了  却发现没有交换一次那就可以说明有序了
            //那么下一次就不用再走外层的冒泡过程了
            if(isSorted) {
                break;
            }

        }
    }

}
