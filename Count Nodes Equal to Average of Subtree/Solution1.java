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
    int result;
    int count;
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }

    private void solve(TreeNode root) {
        if(root == null) {
            return;
        }

        count = 0;
        int total = sum(root);
        int avg = total/count;

        if(root.val == avg) {
            result++;
        }

        solve(root.left);
        solve(root.right);
    }

    private int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        count++;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum + rightSum + root.val;
    }
}
