package impl;

public class TreeTravesal {


    //对 root 为根的树进行遍历
    public static void preOrderTraversal(TreeNode root) {
        //处理根节点
        //处理前提
        if(root != null) {
            System.out.print(root.v);
            //我会很容易想到会不会出现空指针异常去处理
            //root.left  但其实本身处理一颗树的时候，你得先考虑
            //树到底存不存在
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }else  {
        }
    }
    public static void inOrderTraversal(TreeNode root) {
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.v);
            inOrderTraversal(root.right);
        } else  {
        }
    }
    public static void  postOrderTraversal(TreeNode root) {
        if(root !=null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.v);
        }else {
        }
    }



}
