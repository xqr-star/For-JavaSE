package impl;

public class SomeMethod {


    //求结点个数--以root为根
    private static int n;//这里的N 是静态遍历，
    //必须是静态 静态方法只能访问静态的变量
    // 整个类期间有效

    /**
     * 方法一
     * 遍历的思路
     *
     * @param root
     * @return
     */
    public static int sumTreeNodeSize1(TreeNode root) {
        //int n = 0;//局部遍历

        n = 0;//每次数之前都要让n 归零
        preOrder(root);
        return n;
    }

    private static void preOrder(TreeNode root) {
        if (root != null) {
            n++;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 方法二
     * 汇集的思路
     */
    public static int sumTreeNodeSize2(TreeNode root) {
        //一个空的树
        if (root == null) {
            return 0;
        } else {
            //有根节点的树
            int rootNodeSize = 1;//根的结点个数
            int leftSubTreeNode = sumTreeNodeSize2(root.left);
            int rightSubTreeNode = sumTreeNodeSize2(root.right);
            return rootNodeSize + leftSubTreeNode + rightSubTreeNode;
            //打一个条件断点 == root.v == 'A';
        }
    }

    /**
     * 求叶子结点的个数
     * 遍历的思路
     */
    public static int sumTreeLeafNodeSize1(TreeNode root) {
        n = 0;
        preOrder2(root);
        return n;
    }

    public static int preOrder2(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            if (root.left == null && root.right == null) {
                n++;
            } else {
                preOrder2(root.left);
                preOrder2(root.right);
            }
            return n;
        }
    }

    public static int sumTreeLeafNodeSize2(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return sumTreeLeafNodeSize2(root.left) + sumTreeLeafNodeSize2(root.right);
        }
    }

    /**
     * 求第K层结点的个数
     */
    public static int sumKLevelNodeSize(TreeNode root, int k) {
        if (root == null) {
            return 0;
        } else if (root != null && k == 1) {
            return 1;
        } else {
            //求左子树k-1 的结点个数+ 右子树k-1的结点个数
            return sumKLevelNodeSize(root.left, k - 1) + sumKLevelNodeSize(root.right, k - 1);
        }
    }

    /**
     * 求二叉树的高度
     * 汇集的思路
     */
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
            //其实也可以合并处理 --但刚开始处理这样分类比较清楚
        } else {
            //有点点麻烦啦！
//            return max(getHeight(root.left) ,getHeight(root.right))+1;
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }
//    private  static int max(int a,int b ) {
//        return a>b?a:b;
//    }

    public static boolean contains1(TreeNode root,char v) {
        if(root == null) {
            return false;
        }else if(root.v == v) {
            //跟里面找到了就return true
            //没必要去左右子树再去找
            return true;
        }else {
            //跟里面没找到
             boolean b = contains1(root.left,v);
             if(b == true) {
                 //左子树里面找到
                 return true;
             }else {
                 //左子树里面也没找到，去右子树里面找
                return contains1(root.right, v);
             }
        }

    }

    public static boolean contains2(TreeNode root,char v) {
        if(root == null) {
            return false;
        }
        //什么都不写也等同于else
        if(root.v == v) {
            return true;
        }
        //跟里面没找到
        boolean left = contains2(root.left,v);
        if(left) {
            //左子树里面找到
            return true;
        }
        //左子树里面也没找到，去右子树里面找
        return contains2(root.right, v);
    }
}
