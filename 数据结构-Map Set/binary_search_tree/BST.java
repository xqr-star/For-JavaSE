package binary_search_tree;

import com.sun.jmx.snmp.SnmpOidDatabase;

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

    /**
     * cmp 定义位置的不同 处理的方式不同
     * @param key
     * @return
     */

//    public boolean remove(Integer key) {
//        //查找要删除的Key 所在的结点--node
//        //node 的双亲结点记作 parent
//
//        Node parent = null;
//        Node current = root;
//        int cmp = 0;
//        while (current != null) {
//            cmp = key.compareTo(current.val);
//            if (cmp ==0 ){
//                //说明找到了就开始准备删除的工作
//             
//            }else if(cmp < 0) {
//                parent = current;
//                current = current.left;
//            }else {
//                parent = current;
//                current = current.right;
//            }
//        }
//        //循环结束肯是找到了也可能是没找到；
//        //通过cmp 的值来反映
//        if(cmp == 0) {
//            //执行删除操作
//            //在这里写一个方法；
//
//        }else {
//            //说明压根就没这个结点
//        }
//    }

    public boolean remove(Integer key) {
        //查找要删除的Key 所在的结点--node
        //node 的双亲结点记作 parent

        Node parent = null;
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.val);
            if (cmp ==0 ){
                //说明找到了就开始准备删除的工作
                removeInternal(current,parent);
                return true;
            }else if(cmp < 0) {
                parent = current;
                current = current.left;
            }else {
                parent = current;
                current = current.right;
            }
        }
        //循环结束肯是找到了也可能是没找到；
        return false;
    }

    private void removeInternal(Node node, Node parent) {
        //node 是我要删除的结点

        //第一种//判断是不是叶子结点
        if(node.left == null && node.right == null) {
            //在处理让它的双亲结点指向Node 的孩子之前
            //要先看看有没有双亲结点
            if(node == root) {
                root = null;
                return;
            } else if(node == parent.left){
                //不是根节点的时候parent 一定存在
                parent.left = null;
            }else {
                parent.right = null;
            }
        }

        //第二种 要删除的Node 结点只有一个孩子 且是左孩子
        else if(node.left != null && node.right == null) {
            if(node == root) {
                root = node.left;
            }
            //主要是在这里需要判断以下Node 到底是
            //parent 的左还是右
            else if(parent.left == node) {
                parent.left = node.left;
            }else {
                parent.right = node.left;
            }
        }

        //第三种 要删除的Node 结点只有一个孩子 且是右孩子
        else if(node.left == null) {   //(node.left == null && node.right != null)
            if(node == root) {
                root = node.right;
            }
            //主要是在这里需要判断以下Node 到底是
            //parent 的左还是右
            else if(parent.left == node) {
                parent.left = node.right;
            }else {
                parent.right = node.right;
            }
        }

        //第四种 要删除的结点左右都有孩子--采用值的替换法
        //一般而言用左边最大的或者右边最小的值来代替

        //采用左边最大的值来替换 这个替换的结点叫做ghost

        else{  //(node.left != null && node.right != null )
            Node ghostParent = node;
            Node ghost = node.left;

            //找到ghost 和 ghostParent 应该处的位置
            while (ghost.right != null) {
                ghostParent = ghost;
                ghost = ghost.right;
            }
            //结束循环的时候就说明此时已经找到了
            //左子树中可以替换的最大值
            //但是程序到这里
            // 到底这个循环没有进去还是
            // 已经结束是需要仔细考虑的地方
            if(ghostParent == node) {
                node.val = ghost.val;
                ghostParent.left = ghost.left;
            }else {
                node.val = ghost.val;
                ghostParent.right = ghost.left;
            }

        }


    }


}
