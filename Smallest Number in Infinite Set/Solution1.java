class SmallestInfiniteSet {
    int i;
    boolean[] arr;
    public SmallestInfiniteSet() {
        i = 1;
        arr = new boolean[1001];
        Arrays.fill(arr, true);
        arr[0] = false;
    }
    
    public int popSmallest() {
        while(!arr[i]) {
            i++;
        }
        arr[i] = false;
        return i;
    }
    
    public void addBack(int num) {
        arr[num] = true;
        i = Math.min(i, num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
