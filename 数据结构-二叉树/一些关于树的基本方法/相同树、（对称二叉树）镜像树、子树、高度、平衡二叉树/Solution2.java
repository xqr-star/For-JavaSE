package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.val == q.val
                && isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }


    public static boolean isMirror(TreeNode p,TreeNode q) {
        if(p == null && q == null) {
            //规定两个空树是镜像树
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return  p.val == q.val
                && isMirror(p.left,q.right)
                && isMirror(p.right,q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            //规定空树是镜像对称的
            return true;
        }
        //仅仅只是因为多加这么
        //一条判断语句，运行时间和内存消耗大大降低
        //所以有的时候你完全可以放开写
        //在oJ上测一测，到底有没有更优化的地方
        if(root.left == null && root.right == null) {
            return true;
        }
        //只有左右子树互为镜像才是对称的
        return isMirror(root.left,root.right);
    }

    public boolean contains1(TreeNode root,int k) {
        if(root == null) {
            return false;
        }
        if(root.val == k) {
            return true;
        }
        boolean b =contains1(root.left,k);
        if(b == true) {
            return true;
        }
        return contains1(root.right,k);
    }

    public List<TreeNode> contains2(TreeNode root, int k) {
        List<TreeNode> list = new LinkedList<>();
        if(root == null) {
            return null;
        }
        if(root.val == k) {
            list.add(root);
            return list;
        }
        List<TreeNode> leftList = contains2(root.left,k);
        if(leftList !=null) {
            list.addAll(leftList);
            return list;
        }
        List<TreeNode> rightList = contains2(root.left,k);
        if(leftList !=null) {
            list.addAll(rightList);
            return list;
        }
        return list;
    }

    //错了的原因就是 你找到了值相同的 但是判断以该节点的树和t 不一样你就false
    //可是事实上，是不是会存在还有结点的值也相同 树也相同
    //说白了就是你的树没找完

    //-----------------------------------------
    //还是一个没跑过去的错误代码
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//
//        if(s == null) {
//            return false;
//        }
//        if (isSameTree(s,t)) {
//            return true;
//        }
//
//        Boolean b = contains1(s, t.val);
//        //还得返回结点
//        //但是关键为题是你写的contains 只能返回一个值
//        //所以这就很尴尬了
//        //链表保存的是所有值相同的结点
//        List<TreeNode> listKey = contains2(s, t.val);
//        for (TreeNode node : listKey) {
//            if (isSameTree(node, t)) {
//                return true;
//            }
//        }
//        return false;
//    }
//


    //-error 包含了这个值但是树不同，还是得去看看其他节点啊
    //在这写错了
//
//        if(b == true && isSameTree(node,t) ) {
//                return true;
//        }
//        return false;






    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }

        //找到的两个条件
//        if(s.val == t.val) {
//            if(isSameTree(s,t)) {
//                return true;
//            }
//        }
//
        //等同于上面的
        // 本质判断跟的值相同其实等同于判断树是否相同
        if(isSameTree(s,t)) {
            return true;
        }

        //如果值不相等了，你得接着找变整个树
        if(isSubtree(s.left,t)) {
            return true;
        }
        return isSubtree(s.right,t);

    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(   maxDepth(root.left), maxDepth(root.right) ) +1 ;

    }

    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(   maxDepth(root.left), maxDepth(root.right) ) +1 ;
    }


    public boolean isBalanced(TreeNode root) {
        if(root  == null) {
            return true;
        }
        int leftHeight   = getHeight(root.left);
        int rightHeight  = getHeight(root.right);
        int diff = leftHeight - rightHeight;
        if(diff == -1 || diff == 0 ||diff == 1) {
            return false;
        }
        //逻辑漏洞
        //error ----
//        return true;//一定可以这么做吗？
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
