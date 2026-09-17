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
    int maxPath;
    public int longestZigZag(TreeNode root) {
        maxPath = 0;
        solve(root, 0, true);

        return maxPath;
    }

    private void solve(TreeNode root, int steps, boolean goLeft) {
        if(root == null) {
            return;
        }

        maxPath = Math.max(maxPath, steps);

        if(goLeft) {
            solve(root.right, steps + 1, false);
            solve(root.left, 1, true);
        } else {
            solve(root.left, steps + 1, true);
            solve(root.right, 1, false);
        }
    }
}
