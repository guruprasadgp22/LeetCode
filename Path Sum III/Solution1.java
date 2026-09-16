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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }

        return pathSum(root.left, targetSum) + findSum(root, (long)targetSum) + pathSum(root.right, targetSum);
    }

    private int findSum(TreeNode root, long targetSum) {
        if(root == null) {
            return 0;
        }

        int res = 0;

        if(root.val == targetSum) {
            res++;
        }

        res += findSum(root.left, targetSum - root.val);
        res += findSum(root.right, targetSum- root.val);

        return res;
    }
}
