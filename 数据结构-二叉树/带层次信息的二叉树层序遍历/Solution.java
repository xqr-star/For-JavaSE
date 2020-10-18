import java.util.*;

//打印输出按照带层级的层次遍历
public class Solution {

    //用来打包层次和结构
    static class NL {
        TreeNode node;
        int level;

        //构造方法
        public NL(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        @Override
        public String toString() {
            return "NL{" +
                    "node=" + node +
                    ", level=" + level +
                    '}';
        }
    }

    public static void levelOrderWithLevel1(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<NL> queue = new LinkedList<>();
        queue.add(new NL(root,1));
        while (!queue.isEmpty()) {
            NL nl = queue.remove();  //注意取出来的队列元素的类型
//            System.out.println(nl);//重写tostring方法了
            //如果没有
            //取得时候需要拆一下包
            TreeNode node = nl.node;
            int level = nl.level;

            System.out.print(level);
            System.out.println(node.val);

            //queue.add(root.left,2);//意思是这个意思但是不能这么干

            if(node.left != null) {
                queue.add(new NL(node.left,level+1));
            }
            if(node.right != null) {
                queue.add(new NL(node.right,level+1));
            }
        }
    }




    public static void levelOrderWithLevel2(TreeNode root) {

        //搞上两个队列 -- 一个放结点一个放层级 然后一起出来就好了
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        int level = 1;
        nodeQueue.add(root);
        levelQueue.add(level);

        while (!nodeQueue.isEmpty() && ! levelQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            //让两个一起出队列
            System.out.print(levelQueue.remove());
            System.out.println(node);
            //一旦有left 或者 right 就让这个level++
            if(node.left!=null || node.right!=null) {
                level++;
            }
            if(node.left != null) {
                nodeQueue.add(node.left);
                levelQueue.add(level);
            }
            if(node.right != null) {
                nodeQueue.add(node.right);
                levelQueue.add(level);
            }
        }

    }


    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();
        levelOrderWithLevel1(root);
        System.out.println("--------");
        levelOrderWithLevel2(root);


    }


}
