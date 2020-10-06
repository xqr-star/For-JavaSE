package Oj;
//波兰表达式
import java.util.*;
import java.lang.Integer;
public class Solution {

    private List <String> toList(String [] arr) {
        List<String> arrList = new ArrayList<>();
        for(int i = 0 ;i<arr.length;i++) {
            arrList.add(arr[i]);
        }
        return arrList;
    }
    private  int[] stringToInt(String []c) {
        //动态开辟数组长度
        int[] arr = new int[c.length];
        //int i = 0;
        for(String a :c ) {
            for (int i = 0; i < c.length; i++) {
                //String.valueOf 将char 转成str
                //Integer.parseInt 字符串转换为整型
                arr[i] = Integer.parseInt(a);
            }
        }
         return arr;
    }

    //伪代码
//
//    public String evalRPN(String[] tokens) {
//        List<String> arrList = toList(tokens);
//        Deque<String> stack = new LinkedList<>();
//        while(!arrList.isEmpty()) {
//            String c = arrList.remove(0);
//            switch (c){
//                String b ;
//                String a ;
//                String temp;
//                case '+':
//                    b = stack.pop();
//                    a = stack.pop();
//                    temp = b+a;
//                    stack.pop(temp);
//                    break;
//                case'-':
//                    b = stack.pop();
//                    a = stack.pop();
//                    temp = b-a;
//                    stack.pop(temp);
//                    break;
//                case '*':
//                    b = stack.pop();
//                    a = stack.pop();
//                    temp = b*a;
//                    stack.pop(temp);
//                    break;
//                case '/':
//                    b = stack.pop();
//                    a = stack.pop();
//                     temp = b/a;
//                    stack.pop(temp);
//                    break;
//                default:
//                    stack.pop(c);
//            }
//        }
//        return stack.pop();
//    }
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t){
                case "+":
                stack.push(stack.pop() + stack.pop());
                break;
                case "-":
                    //为什么要分开写就是 减法是由顺序的
                    int a = stack.pop();
                stack.push(stack.pop() -  a);
                break;
                case "*":
                stack.push(stack.pop() * stack.pop());
                break;
                case "/":
                    //除法也是由顺序的
                int b= stack.pop();
                stack.push(stack.pop() /b);
                break;
                default:
                stack.push(Integer.valueOf(t));
            }
        }
         return stack.pop();
    }

//    //静态只能访问静态
//    private static void test(int a) {
//        System.out.println(a);
//    }
//    public static void main(String[] args) {
//        Integer a=10;
//        test(a);
//    }
}
