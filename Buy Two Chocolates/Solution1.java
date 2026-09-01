class Solution {
    public int buyChoco(int[] prices, int money) {
        int secondSmallest = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int ele: prices) {
            if(smallest > ele) {
                secondSmallest = smallest;
                smallest = ele;
            } else if(secondSmallest > ele) {
                secondSmallest = ele;
            }
        }

        return money - secondSmallest - smallest < 0? money: money - secondSmallest - smallest;
    }
}
