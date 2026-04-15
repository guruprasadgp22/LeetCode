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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        String paths = String.valueOf(root.val);
        allPaths(root, paths, list);
        return list;
    }
    
    public void allPaths(TreeNode root, String paths, List<String> list) {
        if(root.left == null && root.right == null) {
            list.add(paths);
            return;
        }

        if(root.left != null) {
            allPaths(root.left, paths + "->" + root.left.val, list);
        }

        if(root.right != null) {
            allPaths(root.right, paths + "->" + root.right.val, list);
        }
    }
}
