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
    int preIndex = 0;

    TreeNode buildingTree(int[] preOrder, int[] inOrder, int left, int right) {
        
        if(left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preIndex]);

        int index = search(inOrder, left, right, preOrder[preIndex]);
        preIndex++;

        root.left = buildingTree(preOrder, inOrder, left, index - 1);
        root.right = buildingTree(preOrder, inOrder, index + 1, right);

        return root;
    }

    public int search(int[] inOrder, int left, int right, int val) {
        for(int i=left;i<=right;i++) {
            if(inOrder[i] == val) {
                return i;
            }
        }

        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildingTree(preorder, inorder, 0, preorder.length-1);
    }
}
