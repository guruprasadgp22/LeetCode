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
    HashMap<Integer, Integer> map;
    public int maxLevelSum(TreeNode root) {
        map = new HashMap<>();
        solve(root, 0);

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(max < entry.getValue()) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }

        return ans + 1;
    }

    private void solve(TreeNode root, int depth) {
        if(root == null) {
            return;
        }

        if(map.containsKey(depth)) {
            int sum = map.get(depth) + root.val;
            map.put(depth, sum);
        } else {
            map.put(depth, root.val);
        }

        solve(root.left, depth+1);
        solve(root.right, depth+1);
    }
}
