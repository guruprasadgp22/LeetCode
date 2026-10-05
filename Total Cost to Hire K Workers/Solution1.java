class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        int i = 0;
        int j = costs.length-1;
        int count = 0;
        long total = 0;

        while(count < k) {
            while(queue1.size() < candidates && i <= j) {
                queue1.add(costs[i++]);
            }

            while(queue2.size() < candidates && j >= i) {
                queue2.add(costs[j--]);
            }

            int first = queue1.size() > 0? queue1.peek(): Integer.MAX_VALUE;
            int second = queue2.size() > 0? queue2.peek(): Integer.MAX_VALUE;

            if(first <= second) {
                total += queue1.poll();
            }  else {
                total += queue2.poll();
            }

            count++;
        }

        return total;
    }
}
