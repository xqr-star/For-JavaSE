package bc1;

public class Main {
    /**
     * bc02 大v
     *
     * @param args 1
     */

    public static void main(String[] args) {
        //把它看成一个5*5 的矩阵了
        //5 怎么来
        int count = 3*(3-1);

        int head = 1;
        int end = count;


        //最绝的地方就是它想到了用两个下标来控制
        //打印行数
        for(int i = 1 ;i<=3;i++) {
            //打印每一列
            for(int j = 1;j<=count;j++) {
                if(j == head || j == end) {
                    System.out.print("v");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println("\n");
            //对头和尾修改
            head++;
            end--;
        }

    }
//    public static void main(String[] args) {
//        //输入层数，打印
//        Main.Solution(3);
//    }

    static void Solution(int n) {
        //

        //每一行v和空格的总数=最高层数+(最高层数-1)
        int count = n + (n - 1);
        int head = 1;
        int end = count;

        // 控制打印的层数
        for (int i = n; i > 0; i--) {
            // 循环遍历输出当前层的个数和空格
            for (int j = 1; j <= count; j++) {
                if (j == head || j == end) {
                    System.out.print("v");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            ++head;
            --end;
        }
    }
}



//    public static void main(String[] args) {
//        System.out.println("v   v"+'\n'+" v v "+'\n'+"  v  ");
//    }
//}



//    public static void main(String[] args) {
//        System.out.println("v   v");
//        System.out.println(" v v");
//        System.out.println("  v");
//    }
//}


    /**
     * bc01
     */
//    public static void main(String[] args) {
//        System.out.println("Practice makes perfect!");
//    }
//}
