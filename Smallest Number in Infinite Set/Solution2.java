class SmallestInfiniteSet {
    int curr;
    PriorityQueue<Integer> queue;
    HashSet<Integer> set;
    public SmallestInfiniteSet() {
        curr = 1;
        queue = new PriorityQueue<>();
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        int result;
        if(!queue.isEmpty()) {
            result = queue.poll();
            set.remove(result);
        } else {
            result = curr;
            curr += 1;
        }
        return result;
    }
    
    public void addBack(int num) {
        if(num >= curr || set.contains(num)) {
            return;
        }

        queue.add(num);
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
