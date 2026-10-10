class SegmentTree {
    int n;
    int[] tree;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4*n];
        build(0, 0, n-1, arr);
    }

    void build(int i, int start, int end, int[] arr) {
        if(start == end) {
            tree[i] = arr[start];
            return;
        }
        int mid = start + (end - start)/2;
        build(2*i+1, start, mid, arr);
        build(2*i+2, mid+1, end, arr);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    boolean query(int i, int start, int end, int ele) {
        if(tree[i] < ele) {
            return false;
        }
        if(start == end) {
            tree[i] = -1;
            return true;
        }

        boolean gotBasket = false;
        int mid = start + (end - start)/2;
        if(tree[2*i+1] >= ele) {
            gotBasket = query(2*i+1, start, mid, ele);
        } else {
            gotBasket = query(2*i+2, mid+1, end, ele);
        }

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
        return gotBasket;
    }
}
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int res =0;
        SegmentTree st = new SegmentTree(baskets);
        int n = fruits.length;

        for(int i=0;i<n;i++) {
            if(!st.query(0, 0, n-1, fruits[i])) {
                res++;
            }
        }

        return res;
    }
}
