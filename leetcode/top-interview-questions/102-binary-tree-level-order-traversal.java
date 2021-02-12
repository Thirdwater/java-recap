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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /* Suppose we have a list of nodes in the current level.
         *     Then we can get a list of nodes in the next level by just going through
         *     the current level and adding their children.
         */
        List<List<Integer>> traversal = new ArrayList<List<Integer>>();
        List<TreeNode> currentLevel = new ArrayList<TreeNode>();
        if (root == null) {
            return traversal;
        }
        currentLevel.add(root);
        
        while (!currentLevel.isEmpty()) {
            List<Integer> currentValues = new ArrayList<Integer>();
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for (TreeNode node : currentLevel) {
                currentValues.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            traversal.add(currentValues);
            currentLevel = nextLevel;
        }
        return traversal;
    }
}