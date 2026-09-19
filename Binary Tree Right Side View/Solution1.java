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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        solve(root, 0);

        return result;
    }

    private void solve(TreeNode root, int depth) {
        if(root == null) {
            return;
        }

        if(depth == result.size()) {
            result.add(root.val);
        }

        solve(root.right, depth+1);
        solve(root.left, depth+1);
    }
}
