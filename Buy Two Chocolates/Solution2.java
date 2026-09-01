class Solution2 {
  public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        
        money = money - prices[0] - prices[1];
        
        return money < 0? money + prices[0] + prices[1]: money;
    }
}
