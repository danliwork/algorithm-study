package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        int[] nums = new int[n];
        IntStream.rangeClosed(0,n-1).forEach(i -> nums[i] = i+1);
        return allPossibleTrees(nums, 0, n-1);
    }

    private List<TreeNode> allPossibleTrees(int[] nums, int start, int end){
        if(start > end) return new ArrayList<>();
        if(start == end) {
            TreeNode root = new TreeNode(nums[start]);
            List<TreeNode> res = new ArrayList<>();
            res.add(root);
            return res;
        }
        List<TreeNode> res = new ArrayList<>();
        for(int i = start; i<=end; i++){
            List<TreeNode> lefts = allPossibleTrees(nums, start, i-1);
            List<TreeNode> rights = allPossibleTrees(nums, i+1, end);
            if(lefts.isEmpty()){
                for(TreeNode r : rights){
                    TreeNode root = new TreeNode(nums[i]);
                    root.left = null;
                    root.right = r;
                    res.add(root);
                }
            } else if(rights.isEmpty()){
                for(TreeNode l : lefts){
                    TreeNode root = new TreeNode(nums[i]);
                    root.left = l;
                    root.right = null;
                    res.add(root);
                }
            } else {
                for(TreeNode l : lefts){
                    for(TreeNode r : rights){
                        TreeNode root = new TreeNode(nums[i]);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new UniqueBSTII().generateTrees(3);
    }


}