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
class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (this.isLeaf(root)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return this.isMirror(root.left, root.right);
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return true;
        }
        return node.left == null && node.right == null;
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }

        // Neither or both are leaves
        if ((this.isLeaf(left) && !this.isLeaf(right)) ||
            (!this.isLeaf(left) && this.isLeaf(right))) {
            return false;
        }
        if (this.isLeaf(left) && this.isLeaf(right)) {
            return left.val == right.val;
        }

        // Value check
        if (left.val != right.val) {
            return false;
        }

        // Single-child must be on the opposite side
        if ((left.left == null && right.left == null) ||
            (left.right == null && right.right == null)) {
            return false;
        }
        if (left.left == null && right.right == null) {
            return this.isMirror(left.right, right.left);
        }
        if (left.right == null && right.left == null) {
            return this.isMirror(left.left, right.right);
        }

        // Full-child
        return (this.isMirror(left.right, right.left) &&
                this.isMirror(left.left, right.right));
    }

}
