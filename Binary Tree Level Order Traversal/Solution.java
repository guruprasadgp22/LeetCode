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
    
    List<Integer> ls = new ArrayList<>();

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftNumber = height(root.left);
        int rightNumber = height(root.right);

        return Math.max(leftNumber, rightNumber) + 1;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        int ht = height(root);

        for(int i=1;i<=ht;i++) {
            kthLevel(root, i);
            list.add(new ArrayList<>(ls));
            ls.clear();
        }

        return list;
    }

    public void kthLevel(TreeNode root, int k) {
        if(root == null) {
            return;
        }

        if(k == 1) {
            ls.add(root.val);
            return;
        }
        kthLevel(root.left, k-1);
        kthLevel(root.right, k-1);
    }
}
