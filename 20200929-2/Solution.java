package Oj;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * 括号匹配问题
     * @param
     * @return
     */
    public boolean compareBracket (char left , char c) {
        if(left == '(' && c == ')') {
            return true;
        }
        if(left == '[' && c == ']') {
            return true;
        }
        if(left == '{' && c == '}') {
            return true;
        }
        //出来上述三种情况，其他都是false
        return false;

    }

    public boolean isValid(String s) {
        //准备一个栈 --存放character
        Deque<Character> stack = new LinkedList<>();

        //遍历每一个字符
//        for(int i =0; i<s.length();i++) {
//            char c =s.charAt(i);
//        }
        char [] charArray= s.toCharArray();
        for( char c:charArray) {
            switch(c) {
                case'(':
                case'{':
                case'[':
                    //因为没有break 所以
                    stack.push(c);
                    break;
                    //说明是右括号
                default:
                    if(stack.isEmpty()) {
                        //右括号多了
                        return false;
                    }
                    //否则取出栈顶元素
                    char left = stack.pop();
                    if (!compareBracket(left, c)) {
                        //左右括号不匹配
                        return false;
                    }

            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            //左括号多了
            return false;
        }

    }
}
