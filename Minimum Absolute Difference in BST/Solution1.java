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
    int maxDiff;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        maxDiff = Integer.MAX_VALUE;
        prev = null;

        inOrder(root);

        return maxDiff;
    }

    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        if(prev != null) {
            maxDiff = Math.min(maxDiff, Math.abs(prev.val - root.val));
        }

        prev = root;

        inOrder(root.right);
    }
}
