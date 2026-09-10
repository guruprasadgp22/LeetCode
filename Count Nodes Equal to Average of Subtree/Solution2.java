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

class Pair {
    int sum;
    int count;

    Pair(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}

class Solution {
    int result;
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        postOrder(root);

        return result;
    }

    private Pair postOrder(TreeNode root) {
        if(root == null) {
            return new Pair(0, 0);
        }

        Pair left = postOrder(root.left);
        Pair right = postOrder(root.right);

        int sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;

        if(sum/count == root.val) {
            result++;
        }

        return new Pair(sum, count);
    }
}
