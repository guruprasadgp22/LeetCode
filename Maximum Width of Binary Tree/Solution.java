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
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int max = 0;
        while(queue.size() > 0) {
            int curr = queue.size();
            int startIndex = queue.peekFirst().index;
            int endIndex = queue.peekLast().index;
            
            max = Math.max(max, endIndex - startIndex + 1);

            for(int i=0;i<curr;i++) {
                Pair temp = queue.poll();
                TreeNode t = temp.node;
                int idx = temp.index;

                if(t.left != null) {
                    queue.add(new Pair(t.left, 2 * idx + 1));
                }

                if(t.right != null) {
                    queue.add(new Pair(t.right, 2 * idx + 2));
                }
            }
        }

        return max;
    }
}
