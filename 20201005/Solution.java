package Oj;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //把一个数组转换成List 暂时考虑算法的正确性，不对其进行优化
    public List<Integer> intArrayToList(int []array) {
        List<Integer> list = new ArrayList<>() ;
        for(int i = 0 ;i<array.length;i++) {
            list.add(array[i]);
        }
        return list;
    }

    public Deque<Integer> stack = new LinkedList<>();

    public boolean IsPopOrder(int [] pushA,int [] popA) {

            //转换成list
            List<Integer> pushList = intArrayToList(pushA);
            List<Integer> popList = intArrayToList(popA);

            //数组不能用长度为0 判断是否为空
//        while (pushA.length != 0) {

            //
            //其实还是逻辑思路不清楚
            //主要是当pop 为空的时候，Push 有可能是全满的，这个时候
            //就是得判断是不是为空
            while (!popList.isEmpty()) {
                //大小比较和入栈的操作

                int p = popList.remove(0);
                //删除一号下标的元素
                while(true) {
                    //栈是空的  || 栈顶元素不等于e
                    //???
                    //   if(stack.isEmpty() ||  stack.peek().intValue() != p )
                    if(stack.isEmpty() || p !=stack.peek()) {
                        //表示的就是出栈的元素没有那肯定是空的啊
                        //但我个人觉得这里没有必要判断这个
//                    if(pushList.isEmpty()) {
//                        return false;
//                    }
                        //继续入栈
                        //一定要加这句话，害怕如果列表里面没有元素，会有异常

                        if(pushList.isEmpty()) {
                            return false;
                        }
                        //因为一旦是空的程序就结束了
                        //所以既然程序运行下去就一定不是空，j
                        //就不用写else
                        int q = pushList.remove(0);
                        stack.push(q);

                    } else {
                        //跳出去处理删除元素和出栈的操作
                        break;
                    }
                }
                //在这里处理出栈和删除元素
                stack.pop();
            }
            return stack.isEmpty();
        }
    }
//public class Solution {
//
//    //把一个数组转换成List 暂时考虑算法的正确性，不对其进行优化
//    public static List<Integer> intArrayToList(int []array) {
//        List<Integer> list = new ArrayList<>() ;
//        for(int i = 0 ;i<array.length;i++) {
//            list.add(array[i]);
//        }
//        return list;
//    }
//
//    //准备一个要实现的栈
//    //为什么要加上static 主要是无IsPopOrder是一个静态方法，静态方法只能使用静态的成员变量和属性
//    public static Deque<Integer> stack = new LinkedList<>();
//    public static boolean IsPopOrder(int[] pushA, int[] popA) {
//        //转换成list
//        List<Integer> pushList = intArrayToList(pushA);
//        List<Integer> popList = intArrayToList(popA);
//
//        //数组不能用长度为0 判断是否为空
////        while (pushA.length != 0) {
//
//        //
//        //其实还是逻辑思路不清楚
//        //主要是当pop 为空的时候，Push 有可能是全满的，这个时候
//        //就是得判断是不是为空
//        while (!popList.isEmpty()) {
//            //大小比较和入栈的操作
//
//            int p = popList.remove(0);
//            //删除一号下标的元素
//            while(true) {
//                //栈是空的  || 栈顶元素不等于e
//                if(stack.isEmpty() || p !=stack.peek()) {
//                    //表示的就是出栈的元素没有那肯定是空的啊
//                    //但我个人觉得这里没有必要判断这个
////                    if(pushList.isEmpty()) {
////                        return false;
////                    }
//                    //继续入栈
//                    //一定要加这句话，害怕如果列表里面没有元素，会有异常
//
//                    if(pushList.isEmpty()) {
//                       return false;
//                    }
//                    //因为一旦是空的程序就结束了
//                    //所以既然程序运行下去就一定不是空，j
//                    //就不用写else
//                    int q = pushList.remove(0);
//                    stack.push(q);
//
//                } else {
//                    //跳出去处理删除元素和出栈的操作
//                    break;
//                }
//            }
//            //在这里处理出栈和删除元素
//            stack.pop();
//    }
//        return stack.isEmpty();
//
////        if(!stack.isEmpty()) {
////            return false;
////        }else {
////            return true;
////        }
//    }



    //        //第一个元素相等
//        if (pushA[0] == popA[0]) {
//            删除第一个元素
//        }
//        //第一个元素不相等
//        //和栈顶元素比较
//        while (puS!=0) {
//            if (stack.isEmpty()) {
//                //把pushA的栈顶元素压入
//                stack.push(pushA[0]);
//            } else if (popA[0] == stack.pop()) {
//                //删除栈顶元素 并且 删除Popa的第一个元素
//            } else {
//                //什么也不做 继续压栈
//        }
//       if(popA.length == 0 && pushA.length == 0 && stack.isEmpty()) {
//           //表示该种出栈的方式是可行的
//       }
//       if(pushA.length != 0 ||  !(stack.isEmpty()) ) {
//           //表示这种出栈的方式不可行
//       }





//     while (!popList.isEmpty()) {
//        //大小比较和入栈的操作
//
//        int p = popList.remove(0);
//        //删除一号下标的元素
//        while(true) {
//            //栈是空的  || 栈顶元素不等于e
//            if(stack.isEmpty() || p !=stack.peek()) {
//                //表示的就是出栈的元素没有那肯定是空的啊
//                //但我个人觉得这里没有必要判断这个
////                    if(pushList.isEmpty()) {
////                        return false;
////                    }
//                //继续入栈
//                int q = pushList.remove(0);
//                stack.push(q);
//            } else {
//                //跳出去处理删除元素和出栈的操作
//                break;
//            }
//        }
//        //在这里处理出栈和删除元素
//        stack.pop();
//    }
//        return stack.isEmpty();




