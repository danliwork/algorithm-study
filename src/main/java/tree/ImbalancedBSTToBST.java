package tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/*
Given a BST (Binary Search Tree) that may be unbalanced, convert it into a balanced BST that has minimum possible height.

Examples :

Input:
       30
      /
     20
    /
   10
Output:
     20
   /   \
 10     30


Input:
         4
        /
       3
      /
     2
    /
   1
Output:
      3            3           2
    /  \         /  \        /  \
   1    4   OR  2    4  OR  1    3   OR ..
    \          /                   \
     2        1                     4

 */
@Slf4j
public class ImbalancedBSTToBST {

    TreeNode toBst(TreeNode node){
        List<Integer> list = new ArrayList<>();
        inorder(list, node);
        return build(list, 0, list.size()-1);
    }


    private void inorder(List<Integer> list , TreeNode node){
        if(node == null) return;
        inorder(list, node.left);
        list.add(node.val);
        inorder(list, node.right);
    }

    //end is inclusive
    private TreeNode build(List<Integer> list, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(list, start, mid-1);
        root.right = build(list, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
         /* Constructed skewed binary tree is
                10
               /
              8
             /
            7
           /
          6
         /
        5   */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.left = new TreeNode(5);

        TreeNode res = new ImbalancedBSTToBST().toBst(root);
        //BSTLevelOrder.levelOrder(root);
       // BSTLevelOrder.levelOrder(res);
        BSTPrinter.printNode(root);
        log.info("-------------------");
        BSTPrinter.printNode(res);


    }
}
