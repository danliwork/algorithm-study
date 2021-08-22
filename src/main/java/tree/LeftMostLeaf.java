package tree;



public class LeftMostLeaf {

    private int maxDepth = 0;
    private int left = -1;

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 0);
        return left;
    }

    private void findBottomLeftValue(TreeNode root, int level){
        if(root == null) return ;

        findBottomLeftValue(root.left, level++);
        if(root.left == null && root.right == null){
            if(level > maxDepth){
                maxDepth = level;
                left = root.val;
            }
        }
        findBottomLeftValue(root.right, level++);
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right  = n3;
        new LeftMostLeaf().findBottomLeftValue(n1);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
