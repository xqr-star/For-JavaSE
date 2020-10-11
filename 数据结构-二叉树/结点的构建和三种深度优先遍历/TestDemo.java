package impl;

public class TestDemo {
    public static void main(String[] args) {

        //静态方法不用new 对象,直接调用即可
        TreeNode root = BuildTree.buildTree1();

        System.out.println("前序遍历");
        TreeTravesal.preOrderTraversal(root);
        System.out.println();

        System.out.println("中序遍历");
        TreeTravesal.inOrderTraversal(root);
        System.out.println();

        System.out.println("后序遍历");
        TreeTravesal.postOrderTraversal(root);
        System.out.println();

        System.out.println(SomeMethod.sumTreeNodeSize1(root));
          System.out.println(SomeMethod.sumTreeNodeSize2(root));
        System.out.println(SomeMethod.sumTreeLeafNodeSize1(root));
        System.out.println(SomeMethod.sumTreeLeafNodeSize2(root));
        System.out.println(SomeMethod.sumKLevelNodeSize(root,4));
        System.out.println(SomeMethod.getHeight(root));

        System.out.println(SomeMethod.contains1(root,'A'));
        System.out.println(SomeMethod.contains2(root,'A'));
        System.out.println(SomeMethod.contains1(root,'d'));
        System.out.println(SomeMethod.contains2(root,'d'));
        System.out.println(SomeMethod.contains1(root,'E'));
        System.out.println(SomeMethod.contains2(root,'E'));

        System.out.println(SomeMethod.contains2(null,'E'));
        System.out.println(SomeMethod.contains2(new TreeNode('a'),'E'));
    }

}
