class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();

        int i = 0;
        int j = costs.length-1;
        int count = 0;

        while(count < candidates && i <= j) {
            queue1.add(costs[i++]);
            if(i <= j) {
                queue2.add(costs[j--]);
            }
            count++;
        }

        // if(k == 1)

        count = 0;
        long total = 0;

        while(count < k && !queue1.isEmpty() && !queue2.isEmpty()) {
            int first = queue1.peek();
            int second = queue2.peek();
            // System.out.println(i + "-" + j);
            if(first <= second) {
                total += queue1.poll();
                if(i <= j){
                    queue1.add(costs[i++]);
                }
            } else {
                total += queue2.poll();
                if(i <= j){
                    queue2.add(costs[j--]);
                }
            }
            System.out.println(total);
            count++;
        }

        while(count < k && !queue1.isEmpty()) {
            total += queue1.poll();
            count++;
        }

        while(count < k && !queue2.isEmpty()) {
            total += queue2.poll();
            count++;
        }

        return total;
    }
}
