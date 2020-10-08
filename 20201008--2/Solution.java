package impl;
import java.util.*;
public class Solution {
    //把字符串转成数组 然后转成链表
    public List<Character> toCharList( char[] sArr) {
        List<Character> sList = new LinkedList<>();
        for(char s:sArr) {
            sList.add(s);
        }
        return  sList;
    }

    public Deque<Character> pushStack(List<Character>sList,Deque<Character> stackS) {
        char c ;
        while (!sList.isEmpty()) {
            c = sList.remove(0);
            if(c == '#' && (!stackS.isEmpty()) ) {
                stackS.pop();//删除一个元素
            } else if (c=='#'&& stackS.isEmpty()){
                //c 是退格符 且为空什么也不做
            }else if(c!='#') {
                stackS.push(c);
            }
        }
        return stackS;
    }

    public boolean backspaceCompare(String S, String T) {
        char[] sArr = S.toCharArray();
        char[] tArr = T.toCharArray();

        List<Character>sList = toCharList(sArr);
        List<Character>tList = toCharList(tArr);

        Deque<Character> stackS = new LinkedList<>();
        Deque<Character> stackT = new LinkedList<>();

        stackS = pushStack(sList,stackS);
        stackT = pushStack(tList,stackT);

        //比较两个栈里面的元素是否相等
        return stackS.equals(stackT);
    }
}
