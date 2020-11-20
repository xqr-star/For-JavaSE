package impl;

public class TreeNode {
    public int v;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        v = x;
    }

    public String toString() {

        return String.format("%c", v);
    }
}
