package binary_search_tree;

public class TestCase {
    public static void main(String[] args) {

        //得到的是一颗树
        BST tree = new BST();

        //第一次插入其实就是测试空树插入
        tree.insert(5);
        //第二次插入就是正常情况下的插入测试
        tree.insert(3);
        tree.insert(7);
        tree.insert(9);
        tree.insert(10);
        tree.insert(2);
        tree.insert(0);
        tree.insert(8);
        tree.insert(4);
        tree.insert(1);
        tree.insert(6);

        // 测试插入重复值
        // tree.insert(6);


        //注意这个测试用例的编写
        //为什么是这样的 --边界值都要测到
        //边界值考虑，以及代码范围的覆盖
        //在已有的树里面进行测试

        for(int i = -1 ; i <= 11;i++ ) {
            System.out.println(i+":"+tree.search(i));
        }

        //--其实像这种因为只是   一个名字，一个引用
        //但这个引用其实只用了一次，没有必要
        BST t =  new BST();
        System.out.println(t.search(8));//在空树里面进行测试



        //System.out.println(new BST().search(6));
        //new BST().匿名对象的使用 -- 只是没有赋值一个引用
    }
}
