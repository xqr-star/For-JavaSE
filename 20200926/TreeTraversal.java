package impl.tree;

public class TreeTraversal {
    public static void preTraversal (TreeNode root)  {
        //根节点不为空
        if(root != null) {
            System.out.printf("%c",root.val);
            preTraversal(root.left);
            preTraversal(root.right);
        }
        else {
            //什么都不做
        }

    }
    public static void inTraversal (TreeNode root) {
        if(root != null) {
            inTraversal(root.left);
            System.out.printf("%c",root.val);
            inTraversal(root.right);
        }
        else {
            //什么都不做
        }

    }
    public static void postTraversal (TreeNode root) {
        if(root != null) {
            postTraversal(root.left);
            postTraversal(root.right);
            System.out.printf("%c",root.val);
        }
        else {
            //什么都不做
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');
        TreeNode j = new TreeNode('J');

        a.left = b;
        a.right = c ;

        b.left = d ;
        b.right =null;

        c.left = e;
        c.right = f;

        d.left = null;
        d.right = g;

        e.left = null;
        e.right =null;

        f.left = h;
        f.right = i;

        g.left = j;
        g.right = null;

        //H i j 为空可以不写
        h.left = null;
        h.right = null;

        i.left = null;
        i.right = null;

        j.left = null;
        j.right = null;

        System.out.print("前序遍历");
        preTraversal(a);
        System.out.println();
        System.out.print("中序遍历");
        inTraversal(a);
        System.out.println();
        System.out.print("后序遍历");
        postTraversal(a);





    }
}
