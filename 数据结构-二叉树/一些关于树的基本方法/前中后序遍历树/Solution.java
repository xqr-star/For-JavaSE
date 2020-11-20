package leetcode;
import java.util.*;

/**
 * 前序遍历 以LIST 的形式返回回来
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> preTree = new LinkedList<>();
        if(root != null) {
            preTree.add(root.val);
            List<Integer> leftList = preorderTraversal(root.left);
            preTree.addAll(leftList);
            List<Integer> rightList = preorderTraversal(root.right);
            preTree.addAll(rightList);
        }
        return preTree;

//        if(root != null) {
//
//            preTree.add(root.val);
//
//            preorderTraversal(root.left);
//            //为什么说你这个会出现问题呢？
        //确实做到了遍历，但是preorderTraversal方法的返回值是
        //List<Integer> 的类型，你没有用一个List 来接收它，所以
        //oj上面只有一个值被加进入。
//
//
//
//            preorderTraversal(root.right);
//
//        }
//        //不能直接这么写 空指针异常啦
//        preTree.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return preTree;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inList = new LinkedList<>();
        if(root != null) {
            List<Integer> leftList = inorderTraversal(root.left);
            inList.addAll(leftList);

            inList.add(root.val);

            List<Integer> rightList = inorderTraversal(root.right);
            inList.addAll(rightList);
        }
        return inList;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postList = new LinkedList<>();
        if (root != null) {
            List<Integer> leftList = postorderTraversal(root.left);
            postList.addAll(leftList);

            List<Integer> rightList = postorderTraversal(root.right);
            postList.addAll(rightList);

            postList.add(root.val);
        }
        return postList;
    }



}
