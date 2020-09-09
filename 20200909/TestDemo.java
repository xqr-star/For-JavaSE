import java.util.Scanner;

public class TestDemo {

    /**
     * 递归求解汉诺塔
     */
    public static void hanoi(int n,int a, int b,int c) {
        if(n == 1) {//递归的终止条件
            System.out.printf("Move %d from %d to %d\n",n,a,c);
        }else {
            hanoi(n-1, a, c, b);//将a柱子上的n-1个盘移到b柱子上
            System.out.printf("Move %d from %d to %d\n",n,a,c);
            hanoi(n-1, b, a, c);//将b柱子上的n-1个盘子移到c柱子上
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int number=scan.nextInt();
        hanoi(number,1,2,3);
        //hanoi(number,A,B,C)因为接受的是整型所以不能写字符串类型;
    }
}
