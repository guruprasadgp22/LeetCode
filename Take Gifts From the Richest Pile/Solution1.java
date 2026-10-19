class Solution {
    public long pickGifts(int[] gifts, int k) {
        long totalSum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for(int ele: gifts) {
            queue.add(ele);
            totalSum += ele;
        }

        long sum = 0;
        while(k > 0) {
            int num = queue.poll();
            int diff = (int)(num - Math.floor(Math.sqrt(num)));
            sum += diff;
            queue.add(num - diff);
            k--;
        }

        return totalSum - sum;
    }
} 
