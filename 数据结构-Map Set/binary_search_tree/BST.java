package binary_search_tree;

public class BST {

    //根的属性是非静态的，是和对象有关系的
    private Node root;

    public BST() {
        root = null;
    }

    /**
     * 关于方法签名为什么这么写
     * 需要知道  为什么是非静态的方法
     * 因为查找的过程是和对象有关系的
     */
    public boolean search(Integer key) {
        //1-处理空树
        //2.处理一个结点的树
        //key是要查找的数字
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.val);
            if( cmp == 0) {
                return true;//找到了
            }else if(cmp < 0) {
                //说明Key 比当前结点要小 那就去左边找
                current = current.left;
            }else {
                current = current.right;
            }
        }
        //遍历完了整个树还没有找到
        return false;
    }



    public boolean insert(Integer key) {
        if(root == null) {
            root = new Node(key);
            return true;
        }
        Node current = root;
        Node parent = null; //  null ?? haishi root ??始终保持Parent 是current 的双亲结点、

        Node node = new Node(key);
        int num;

        //因为我上面已经处理过current 为空的情况了
        //所以在这里就不用考虑空指针异常了
        int cmp = key.compareTo(current.val);
        //这个句子还不能放在这里
        //每次进来还得修改cmp 的值 每次current 都会变得
        //但是你循环里面一直在用原来的cmp
        while (current != null) {
            cmp = key.compareTo(current.val);
            parent = current;
            //然后判断current 往哪里走
            if(cmp == 0) {
                //说明相等了
                //相等就抛出异常
                throw new RuntimeException("BST 中不允许出现相同的 key");
            } else if(cmp <0) {
                current = current.left;
            }else {
                current = current.right;
            }
        }

        //程序没有抛出异常就说明树里面没有这个关键字
        //没有这个关键字就得知道往哪里插入


        //循环跳出就说明树里面里面没有要找的数字
        //现在就是考虑要往双亲结点的哪里插入的问题
        //利用cmp 的值来解决
        //cur == null
        if(cmp > 0) {
            parent.right = node;
        }else {
            parent.left = node;
        }

        //在做插入之前要先查找有没有这个关键字

        //有了就return false
        //没有就插入

        return true;

    }



}
