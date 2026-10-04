class SmallestInfiniteSet {
    int curr;
    TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        curr = 1;
        set = new TreeSet<>();
    }
    
    public int popSmallest() {
        int result;
        if(!set.isEmpty()) {
            result = set.removeFirst();
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
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
