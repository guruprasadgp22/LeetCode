class NumArray {
    int n;
    int[] tree;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4*n];
        build(0, 0, n-1, nums);
    }

    void build(int node, int start, int end, int[] nums) {
        if(start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = start + (end - start)/2;
        build(2*node+1, start, mid, nums);
        build(2*node+2, mid+1, end, nums);

        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
    
    public void update(int index, int val) {
        updateST(0, 0, n-1, index, val);
    }

    void updateST(int node, int start, int end, int index, int val) {
        if(start == end) {
            tree[node] = val;
            return;
        }

        int mid = start + (end - start)/2;
        if(index <= mid) {
            updateST(2*node+1, start, mid, index, val);
        } else {
            updateST(2*node+2, mid+1, end, index, val);
        }

        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
    
    public int sumRange(int left, int right) {
        return query(0, 0, n-1, left, right);   
    }

    private int query(int node, int start, int end, int left, int right) {
        if(right < start || left > end) {
            return 0;
        }

        if(left <= start && right >= end) {
            return tree[node];
        }

        int mid = start + (end - start)/2;
        int leftSide = query(2*node+1, start, mid, left, right);
        int rightSide = query(2*node+2, mid+1, end, left, right);
        return leftSide + rightSide;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
