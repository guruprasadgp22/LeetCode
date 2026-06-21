class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int count = 0;
        Arrays.sort(costs);

        while(count < costs.length && costs[count] <= coins) {
            coins = coins - costs[count];
            count++;
        }

        return count;
    }
}
