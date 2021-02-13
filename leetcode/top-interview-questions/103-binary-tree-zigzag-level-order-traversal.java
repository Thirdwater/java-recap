/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /* Suppose we have a list of nodes in the current level.
         *     Then we can get a list of nodes in the next level by simply
         *     going through the list (either in-order or reverse).
         */
        List<List<Integer>> traversal = new ArrayList<List<Integer>>();
        List<TreeNode> currentLevel = new ArrayList<TreeNode>();
        if (root == null) {
            return traversal;
        }
        currentLevel.add(root);
        boolean reverse = false;
        
        while (!currentLevel.isEmpty()) {
            List<Integer> currentValues = new ArrayList<Integer>();
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            
            if (reverse) {
                for (int i = currentLevel.size() - 1; i >= 0; i--) {
                    TreeNode node = currentLevel.get(i);
                    currentValues.add(node.val);
                    if (node.right != null) {
                        nextLevel.add(0, node.right);
                    }
                    if (node.left != null) {
                        nextLevel.add(0, node.left);
                    }
                }
                reverse = false;
            } else {
                for (TreeNode node : currentLevel) {
                    currentValues.add(node.val);
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                }
                reverse = true;
            }
            
            traversal.add(currentValues);
            currentLevel = nextLevel;
        }
        return traversal;
    }
}