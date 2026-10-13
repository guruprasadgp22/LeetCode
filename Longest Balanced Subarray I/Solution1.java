class Node {
    int min;
    int max;

    Node(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

class SegmentTree {
    int n;
    Node[] tree;
    int[] lazy;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new Node[4 * n];
        lazy = new int[4 * n];
        build(0, 0, n - 1, arr);
    }

    void build(int i, int start, int end, int[] arr) {
        if (start == end) {
            tree[i] = new Node(0, 0);
            return;
        }

        int mid = start + (end - start) / 2;
        build(2 * i + 1, start, mid, arr);
        build(2 * i + 2, mid + 1, end, arr);

        tree[i] = new Node(Math.min(tree[2 * i + 1].min, tree[2 * i + 2].min),
                Math.max(tree[2 * i + 1].max, tree[2 * i + 2].max));
    }

    void update(int left, int right, int val) {
        update(0, 0, n-1, left, right, val);
    }

    void update(int i, int start, int end, int left, int right, int val) {
        propagate(i, start, end);

        if(left > end || right < start) {
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

        tree[i].min = Math.min(tree[2*i+1].min, tree[2*i+2].min);
        tree[i].max = Math.max(tree[2*i+1].max, tree[2*i+2].max);
    }

    int get() {
        return query(0, 0, n-1);
    }

    int query(int i, int start, int end) {
        propagate(i, start, end);

        if(tree[i].min > 0 || tree[i].max < 0) {
            return -1;
        }

        if(start == end) {
            return start;
        }

        int mid = start + (end - start)/2;
        int leftVal = query(2*i+1, start, mid);
        if(leftVal != -1) {
            return leftVal;
        }

        return query(2*i+2, mid+1, end);
    }

    void propagate(int i, int start, int end) {
        if(lazy[i] != 0) {
            tree[i].min += lazy[i];
            tree[i].max += lazy[i];

            if(start != end) {
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }

            lazy[i] = 0;
        }
    }
}

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        SegmentTree st = new SegmentTree(nums);
        for(int i=0;i<n;i++) {
            int val = nums[i] % 2 == 0? 1: -1;
            int prev = -1;
            if(map.containsKey(nums[i])) {
                prev = map.get(nums[i]);
            }

            if(prev != -1) {
                st.update(0, prev, -val);
            }

            st.update(0, i, val);

            int l = st.get();
            if(l != -1) {
                result = Math.max(result, i - l + 1);
            }
            map.put(nums[i], i);
        }

        return result;
    }
}
