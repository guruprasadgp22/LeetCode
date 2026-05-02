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
    int prevOrder = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }

        if(root.left != null) {
            int leftKey = kthSmallest(root.left, k);
            if(leftKey != -1) {
                return leftKey;
            }
        }

        if(prevOrder + 1 == k) {
            return root.val;
        }

        prevOrder += 1;

        if(root.right != null) {
            int rightKey = kthSmallest(root.right, k);

            if(rightKey != -1) {
                return rightKey;
            }
        }

        return -1;
    }
}
