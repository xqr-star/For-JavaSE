package leetcode;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class Oj {

    public static  void levelOrderTraversal(TreeNode root) {
        if(root == null) {
            return;//空树的层序遍历，没有什么可以做的
        }
        //准备一个放结点的队列
        Queue<TreeNode> queue = new LinkedList<>();
        //把根节点放入队列中
        queue.add(root);
        //开始打印队首元素以及将左右孩子拖入栈中同时出队首元素
        //这是经验
        //循环条件不知道先写什么的时候可以先写true
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.val);
            //
            if(node.left !=null) { //--> 判断保证了这个队列里面一定不会出现null
                //root 有左孩子
                queue.add(node.left);
            }
            if (node.right != null) {
                //root 有右孩子
                queue.add(node.right);
            }
        }
        //说明队列空了
        //也就说明元素拖完了，遍历结束！
    }
    public static boolean isCompleteTree (TreeNode root) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            //检查队列中是否有空的元素
            //如果一点出现循环结束
            //看看空的后面是否有非空
            TreeNode node = queue.remove();
            if (node == null) {
                //在遇到node == null 之前可能出现队列为空的情况吗？
                //而且跳出循环的时候，不一定能保证所有元素被拖进来
                break;
            }
            //队首元素部位空就接着拖进去左右孩子
            // --》不管左右孩子是不是Null
            queue.add(node.left);
            queue.add(node.right);

        }
        //上面的while正常循环结束的时候，
        //所有的元素都已经被检查过了
        //正常结束队列一定为空
        //所以非正常的情况下--队列不为空

        //检查队列的剩余元素
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.remove();
//            if(node == null) {
//                //当前元素为null s
//                //什么也说明不了
//                //你得看后面啊
//            }else {
//                //只有出现了非null了 才说明一定不是完全二叉
//                return false;
//            }
//        }
//        return true;


        for(TreeNode node:queue) {
            //为空的时候不能说明
            //只有不为null 才行
            if (node != null) {
                return false;
            }
        }
        return true;


//        for(TreeNode node:queue) {
//            //为空的时候不能说明
//            //只有不为null 才行
//            if (node != null) {
//                return true;
//            }
//        }
//        return false;
            //--错误分析
        //你写了一个for 循环表面对队列进行检查
        //不管队列是否为空

        //如果队列正常循环结束的话你现在for循环的就是一个空队列
        //之后你retuen false --本来是true
        //如果队列不正常循环结束 检查队列
        //不为空返回false才合理

    }


}
