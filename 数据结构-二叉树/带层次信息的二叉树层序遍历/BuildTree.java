public class BuildTree {
    public static TreeNode buildTree1() {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left= f;
        c.right= g;


        d.left= h;

        return a;
    }
}
