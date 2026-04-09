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
class Tuple {
    int vertical;
    int level;
    TreeNode node;

    Tuple(int vertical, int level, TreeNode node) {
        this.vertical = vertical;
        this.level = level;
        this.node = node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(0, 0, root));

        while(!queue.isEmpty()) {
            Tuple temp = queue.poll();
            int verti = temp.vertical;
            int lev = temp.level;
            TreeNode value = temp.node;

            if(!map.containsKey(verti)) {
                map.put(verti, new TreeMap<>());
            }

            if(!map.get(verti).containsKey(lev)) {
                map.get(verti).put(lev, new PriorityQueue<>());
            }
            map.get(verti).get(lev).offer(value.val);

            if(value.left != null) {
                queue.add(new Tuple(verti-1, lev+1, value.left));
            }
            if(value.right != null) {
                queue.add(new Tuple(verti+1, lev+1, value.right));
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        for(Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry: map.entrySet()) {
            List<Integer> ls = new ArrayList<>();
            TreeMap<Integer, PriorityQueue<Integer>> m = entry.getValue();
            for(Map.Entry<Integer, PriorityQueue<Integer>> en: m.entrySet()) {
                PriorityQueue<Integer> pq = en.getValue();
                while(!pq.isEmpty()) {
                    ls.add(pq.poll());
                }
            }

            list.add(ls);
        }

        return list;
    }
}
