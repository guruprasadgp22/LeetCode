class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        for(int ele: nums) {
            queue.add(ele);
        }

        while(k > 1){
            queue.poll();
            k--;
        }
        return queue.poll();
    }
}
