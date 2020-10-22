package sort;

public class selectSort {
    public static  void selectSort(long[] arr) {
        //对数组的元素进行选择的过程 -- 外侧循环表示选择的过程
        for(int i = 0; i< arr.length-1;i++) {

            //找到无序区间里里面最大的元素和无序区间的最后一个交换
            //无序区间 [0 - arr.length-i)
            int maxIndex = 0;
            //遍历整个无序区间找到最大的元素的下标
            int j = 0;
            for( j = 0 ; j <arr.length-i ; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            //把最大和无序的最后一个交换 -- 就会涉及到下标的问题
            insertSort.swap(arr,maxIndex,j-1);
            //swap(arr,maxIndex ,arr.length-i - i)
        }
    }

}
