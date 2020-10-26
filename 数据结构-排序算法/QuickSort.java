package sort;

import static sort.insertSort.swap;

public class QuickSort {
    public static void quickSort(long[] arr) {
        int lowIndex = 0;
        int highIndex = arr.length-1;
        //采用闭区间的做法
        quickSortInternal(arr,lowIndex,highIndex);
    }

    private static void quickSortInternal(long[] arr,int lowIndex,int highIndex) {

        //为什么不能用这个？if(arr.length == 0 ||)
        //因为其实在整个的做法中，我从来没有对arr 的长度进行更改
        //arr 是一直不变的 只会变化上下界

        //采用闭区间的做法
        int size = highIndex - lowIndex + 1;
        if(size <= 1) {
            return;//也就是递归的出口
        }

        //选择最左边的数字作为基准（目前是随便的也没啥标准）
        //注意注意最左边的数字是arr[lowIndex] 而不是 arr[0]

        //第二部执行partition 操作
        //KeyIndex 是经过partition 之后 以基准的数进行分割，
        // 基准的数的下标
        int keyIndex = partitionHover(arr,lowIndex,highIndex);

        //再分别对左右区间进行相同的操作
        quickSortInternal(arr,lowIndex,keyIndex-1);
        quickSortInternal(arr,keyIndex+1,highIndex);

    }


    /**
     * 实现Partion
     * @param arr
     * @param lowIndex
     * @param highIndex
     * @return
     */

    //
    //hoare 法
    private static  int partitionHover(long[]arr ,int lowIndex, int highIndex) {
        //1.选择基准  即为arr[ lowIndex ] 作为特殊的数组
        //2.需要遍历真个区间（不是数组！！！）比他大的放后面
        //采用左闭右闭
        //小的放前面
        //我不用保证左右两个区间有顺序要求 只要小的放左边就好了

        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        //选择的数是最左边的一个
        long key = arr[lowIndex];
        //当你选了最左边的数字的时候，要从最后边走
        while (leftIndex < rightIndex) {
            //但是要注意这个循环由于一直在++ --
            //也要考虑下标越界的问题
            //为什么arr[leftIndex] <= key 必须要加这个等号
            //注意注意再注意哈 本来你的leftIndex 就是指向的key
            //你现在arr[leftIndex] < key  那条件不成立，直接让lowIndex 和key 交换了
            //可是事实上这个key 还没有找到正确交换的位置

            //关于为什么arr[rightIndex] >= key
            //有了=这要一定可以保证数据是有序的。 和他相等的一定不会被放到前面去
            while(leftIndex <rightIndex && arr[rightIndex] >= key) {
                rightIndex--;
            }
            while(leftIndex <rightIndex && arr[leftIndex] <= key) {
                leftIndex++;
            }
            //跳出来的时候说明右边先找到了比key 小的
            //左边也找到了比Key大的，开始交换
            swap(arr,leftIndex,rightIndex);
        }
        //跳出循环的时候，说明LeftIndex == rightIndex
        // 把Key 和 Leftright 位置交换
        swap(arr,lowIndex,leftIndex);
        //swap(arr,lowIndex,rightIndex); 都可以
        return leftIndex;//现在返回的就是key所在的位置啦！
    }



}
