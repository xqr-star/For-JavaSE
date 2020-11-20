package sort;

public class heapSort {

    public static void heapSort(long[] arr) {
        //对数组进行建立大堆的操作
        createHeap(arr,arr.length);

        //一个循环操作 --- 进行 n - 1次选择
        for(int i = 0; i< arr.length-1;i++) {

            //无序区间【0 - arr,length-i)
            //把0 号下标和无序区间的最后一个进行交换
            insertSort.swap(arr,0,arr.length-i-1);
            //现在无序区间 [0 - arr.length-i-1)
            //同时对堆进行向下调整
            //对 0 号下标进行向下调整--还需要知道元素的个数
            adjustDown(arr,arr.length - i -1,0);

        }

    }
    public static void createHeap(long[] arr, int size) {
        //从最后一个非叶子结点开始不断地对其进行向下调整
        for(int i = (size - 2) /2 ;i >= 0 ;i--) {
            adjustDown(arr,size,i);
        }

    }
    public static void adjustDown(long[] arr,int size,int index) {
        //满足这个条件说明不是叶子节点
        //2*index + 1  --左孩子下标
        while (2*index + 1 <size) {
            //定义左孩子
            int maxIndex = 2 *index +1;
            //右孩子存在并且比左孩子大
            if(maxIndex +1 < size && arr[maxIndex] < arr[maxIndex+1]) {
                //maxIndex++;
                maxIndex = maxIndex+1;
            }

            //如果比叶子结点大就不要交换了
            if(arr[index] >= arr[maxIndex] ){
                break;
            }

            insertSort.swap(arr,index,maxIndex);
            //接着向下调整

            index = maxIndex; //把maxindex 的下标赋值给index 从原来的maxindex 所在位置开始重新调整
        }
    }

}
