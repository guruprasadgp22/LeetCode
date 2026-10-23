class Pair {
    int price;
    int span;

    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}
class StockSpanner {
    Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int days = 1;

        while(!stack.isEmpty() && stack.peek().price <= price) {
            days += stack.peek().span;
            stack.pop();
        }

        stack.add(new Pair(price, days));
        return days;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
