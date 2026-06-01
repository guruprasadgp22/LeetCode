class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int min = 0;

        for(int i=cost.length-1;i>=0;i-=3) {
            min += cost[i];

            if(i - 1 >= 0) {
                min += cost[i-1]; 
            }
        }

        return min;
    }
}
