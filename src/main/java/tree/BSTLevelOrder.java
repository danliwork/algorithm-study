package tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class BSTLevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        //edge cases
        if(root == null) return Collections.emptyList();

        //main
        List<List<Integer>> result = new ArrayList<>();

        //recursion
        levelOrderHelper(root, 0, result);

        result.forEach(e -> log.info("" + e.toString()));
        return result;
    }

    //pre-order
    private static void levelOrderHelper(TreeNode root, int level, List<List<Integer>> result){
        //stop condition
        if(root == null) return;

        // process this node
        if(result.size() <= level){
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }
        result.get(level).add(root.val);

        //sub: here check null OR in stop condition?
        levelOrderHelper(root.left, level + 1, result);
        levelOrderHelper(root.right, level + 1, result);
    }
}
