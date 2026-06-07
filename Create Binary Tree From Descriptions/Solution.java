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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> childSet = new HashSet<>();

        for(int[] val: descriptions) {
            int parent = val[0];
            int child = val[1];
            int isLeft = val[2];

            if(!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }

            if(!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }

            if(isLeft == 1) {
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }

            childSet.add(child);
        }

        for(int[] val: descriptions) {
            int parent = val[0];

            if(!childSet.contains(parent)) {
                return map.get(parent);
            }
        }

        return null;
    }
}
