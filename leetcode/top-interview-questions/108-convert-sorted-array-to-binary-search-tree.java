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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return this.recursiveSortedArrayToBST(nums, 0, nums.length - 1);
    }
    private TreeNode recursiveSortedArrayToBST(int[] nums, int start, int end) {
        int numNodes = end - start + 1;
        if (numNodes == 1) {
            return new TreeNode(nums[start]);
        }
        if (numNodes == 2) {
            return new TreeNode(nums[end], new TreeNode(nums[start]), null);
        }

        int mid = (start + end) / 2;
        int value = nums[mid];
        TreeNode left = this.recursiveSortedArrayToBST(nums, start, mid - 1);
        TreeNode right = this.recursiveSortedArrayToBST(nums, mid + 1, end);
        return new TreeNode(value, left, right);
    }
}
