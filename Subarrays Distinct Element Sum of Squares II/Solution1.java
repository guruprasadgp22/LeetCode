class Node {
    long sum;
    long square;

    Node() {
        this.sum = 0;
        this.square = 0;
    }

    Node(long sum, long square) {
        this.sum = sum;
        this.square = square;
    }
}

class SegmentTree {
    int n;
    Node[] tree;
    long lazy[];

    SegmentTree(int n) {
        this.n = n;
        tree = new Node[4*n];
        for(int i=0;i<4*n;i++) {
            tree[i] = new Node();
        }
        lazy = new long[4*n];
    }

    void update(int left, int right, int val) {
        update(0, 0, n-1, left, right, val);
    }

    void update(int i, int start, int end, int left, int right, int val) {
        propagate(i, start, end);
        if(left > end || right < start || start > end) {
            return;
        }

        if(left <= start && right >= end) {
            lazy[i] += val;
            propagate(i, start, end);
            return;
        }

        int mid = start + (end - start)/2;
        update(2*i+1, start, mid, left, right, val);
        update(2*i+2, mid+1, end, left, right, val);

        tree[i].sum = tree[2*i+1].sum + tree[2*i+2].sum;
        tree[i].square = tree[2*i+1].square + tree[2*i+2].square;
    }

    void propagate(int i, int start, int end) {
        if(lazy[i] != 0) {
            long val = lazy[i];
            int len = end - start + 1;
            tree[i].square = tree[i].square + 2 * val * tree[i].sum + (len * val * val);
            tree[i].sum += len * val;

            if(start != end) {
                lazy[2*i+1] += val;
                lazy[2*i+2] += val;
            }

            lazy[i] = 0;
        }
    }

    long query() {
        return tree[0].square;
    }
}
class Solution {
    public int sumCounts(int[] nums) {
        int n = nums.length;
        long result = 0;
        int MOD = 1_000_000_007;

        int[] lastSeenIdx = new int[100001];
        Arrays.fill(lastSeenIdx, -1);

        SegmentTree st = new SegmentTree(n);

        for(int i=0;i<n;i++) {
            int start = lastSeenIdx[nums[i]] + 1;
            int end = i;

            st.update(start, end, 1);
            result = (result + st.query())%MOD;

            lastSeenIdx[nums[i]] = i;
        }

        return (int)result;
    }
}
