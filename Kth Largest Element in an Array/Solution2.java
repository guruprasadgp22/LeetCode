class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int ele: nums) {
            queue.add(ele);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }
}
