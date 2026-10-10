class SegmentTree {
    int[] tree;
    SegmentTree(int n) {
        tree = new int[4*n];
    }

    long query(int i, int start, int end, int left, int right) {
        if(left > end || right < start) {
            return 0;
        }

        if(left <= start && right >= end) {
            return tree[i];
        }

        int mid = start + (end - start)/2;
        long leftVal = query(2*i+1, start, mid, left, right);
        long rightVal = query(2*i+2, mid+1, end, left, right);

        return leftVal + rightVal;
    }

    void update(int i, int start, int end, int index) {
        if(start == end) {
            tree[i] = 1;
            return;
        }
        int mid = start + (end - start)/2;
        if(index <= mid) {
            update(2*i+1, start, mid, index);
        } else {
            update(2*i+2, mid+1, end, index);
        }

        tree[i] = tree[2*i+1] + tree[2*i+2];
    }
}
class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums2.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(nums2[i], i);
        }

        long result = 0;

        SegmentTree st = new SegmentTree(n);
        st.update(0, 0, n-1, map.get(nums1[0]));

        for(int i=1;i<n;i++) {
            int index = map.get(nums1[i]);
            long leftCommonCount = st.query(0, 0, n-1, 0, index);
            long leftUnCommonCount = i - leftCommonCount;
            long rightCount = n - 1 - index;
            long rightCommonCount = rightCount - leftUnCommonCount;

            result += leftCommonCount * rightCommonCount;

            st.update(0, 0, n-1, index);
        }

        return result;
        
    }  
}
