public class TestDemo2 {
    /**
     * 打印数组的内容
     */
    public static void main(String[] args) {


    }
    /**
     * 遍历数组
     */
    public static void main2(String[] args) {
        //普通遍历数组
        int []arr={1,2,3,4};
//        for(int i=0;i<arr.length;i++) {
//            System.out.println(arr[i]);
//        }
        //for-each 遍历数组
        for(int i:arr) {
            System.out.println(i);
        }
    }




    /**
     * 数组的创建
     * @param args
     */
    public static void main1(String[] args) {
        int[] arr1=new int[]{1,2,3};
        System.out.println(arr1.length);
        int[] arr2={1,2,3};
        System.out.println(arr2.length);
        int[] arr3 =new int[3];//随机值0
        System.out.println(arr3.length);

    }
}
