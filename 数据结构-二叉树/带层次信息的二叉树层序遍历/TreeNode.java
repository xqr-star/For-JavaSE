public class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char val) { this.val = val; }

    @Override
//       public String toString() {
//        return "TreeNode{" +
//                "val=" + val +
//                '}';
//    }


        public String toString() {
        return String.format("%c", val);
    }


}
