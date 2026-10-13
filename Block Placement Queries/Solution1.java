class SegmentTree {
    int n;
    int[] tree;

    SegmentTree(int n) {
        this.n = n;
        tree = new int[4 * n];
    }

    void update(int i, int start, int end, int index, int val) {
        if (start == end) {
            tree[i] = val;
            return;
        }

        int mid = start + (end - start) / 2;
        if (index <= mid) {
            update(2 * i + 1, start, mid, index, val);
        } else {
            update(2 * i + 2, mid + 1, end, index, val);
        }

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    int query(int i, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }

        if (left <= start && right >= end) {
            return tree[i];
        }

        int mid = start + (end - start) / 2;
        return Math.max(query(2 * i + 1, start, mid, left, right), query(2 * i + 2, mid + 1, end, left, right));
    }
}

class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int n = 50001;
        SegmentTree st = new SegmentTree(n);
        List<Boolean> result = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(n);

        for (int[] x : queries) {
            if (x[0] == 1) {
                int block = x[1];
                int prev = set.lower(block);
                int next = set.higher(block);
                st.update(0, 0, n - 1, next, next - block);
                st.update(0, 0, n - 1, block, block - prev);
                set.add(block);
            } else {
                int block = x[1];
                int blockSize = x[2];
                int lower = set.floor(block);
                int ans = st.query(0, 0, n - 1, 0, lower);
                int best = Math.max(ans, block - lower);
                result.add(best >= blockSize);
            }
        }

        return result;
    }
}
