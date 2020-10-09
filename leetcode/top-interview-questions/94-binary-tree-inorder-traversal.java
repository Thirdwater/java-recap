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
import java.util.LinkedList;

class Solution {
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> path = new LinkedList<>();
        if (node == null) {
            return path;
        }
        if (node.left != null) {
            path.addAll(inorderTraversal(node.left));
        }
        path.add(node.val);
        if (node.right != null) {
            path.addAll(inorderTraversal(node.right));
        }
        return path;
    }
}
