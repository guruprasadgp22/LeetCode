class Node {
    int[] count;
    int product;

    Node(int k) {
        count = new int[k];
        product = 1;
    }

    Node(int[] count, int product) {
        this.count = count;
        this.product = product;
    }
}

class SegmentTree {
    int n;
    int k;
    Node[] st;

    SegmentTree(int k, int[] nums) {
        this.k = k;
        n = nums.length;
        st = new Node[4 * n];
        buildST(0, 0, n-1, nums);
    }

    void buildST(int node, int start, int end, int[] nums) {
        if(start == end) {
            st[node] = new Node(k);
            leafNode(node, nums[start]);
            return;
        }

        int mid = start + (end - start)/2;
        buildST(2*node+1, start, mid, nums);
        buildST(2*node+2, mid+1, end, nums);

        st[node] = merge(st[2*node+1], st[2*node+2]);
    }

    private void leafNode(int node, int val) {
        Arrays.fill(st[node].count, 0);
        int rem = val % k;
        st[node].count[rem] = 1;
        st[node].product = rem;
    }

    Node merge(Node left, Node right) {
        Node result = new Node(k);

        result.product = (left.product * right.product) % k;
        for(int x=0;x<k;x++) {
            result.count[x] = left.count[x];
        }

        for(int x=0;x<k;x++) {
            int rem = (left.product * x) % k;
            result.count[rem] += right.count[x];
        }

        return result;
    }

    void update(int index, int val) {
        updateSegTree(0, 0, n-1, index, val);
    }

    void updateSegTree(int node, int start, int end, int index, int val) {
        if(start == end) {
            leafNode(node, val);
            return;
        }

        int mid = start + (end - start)/2;
        if(index <= mid) {
            updateSegTree(2*node+1, start, mid, index, val);
        } else {
            updateSegTree(2*node+2, mid+1, end, index, val);
        }

        st[node] = merge(st[2*node+1], st[2*node+2]);
    }

    Node query(int left, int right) {
        return querySegTree(0, 0, n-1, left, right);
    }

    Node querySegTree(int node, int start, int end, int left, int right) {
        if(left <= start && right >= end) {
            return st[node];
        }

        if(right < start || left > end) {
            return new Node(k);
        }

        int mid = start + (end - start)/2;
        if(right <= mid) {
            return querySegTree(2*node+1, start, mid, left, right);
        } else if(left > mid) {
            return querySegTree(2*node+2, mid+1, end, left, right);
        } else {
            Node l = querySegTree(2*node+1, start, mid, left, right);
            Node r = querySegTree(2*node+2, mid+1, end, left, right);
            return merge(l, r);
        }
    }
}
class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        SegmentTree st = new SegmentTree(k, nums);

        for(int i=0;i<queries.length;i++) {
            int index = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            st.update(index, val);
            Node r = st.query(start, nums.length-1);
            result[i] = r.count[x];
        }       

        return result;
    }
}
