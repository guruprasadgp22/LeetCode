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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    private int solve(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        int all = left + right + root.val;
        int skip = Math.max(left, right) + root.val;
        int skipboth = root.val;

        maxSum = Math.max(maxSum, Math.max(all, Math.max(skip, skipboth)));
        return Math.max(skip, skipboth);
    }
}
