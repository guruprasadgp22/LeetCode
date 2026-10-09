class SegmentTree {
    int n;
    int[] tree;

    SegmentTree(int[] heights) {
        n = heights.length;
        tree = new int[4*n];
        build(0,0,n-1, heights);
    }

    void build(int i, int start, int end, int[] arr) {
        if(start == end) {
            tree[i] = start;
            return;
        }

        int mid = start + (end - start)/2;
        build(2*i+1, start, mid, arr);
        build(2*i+2, mid+1, end, arr);

        tree[i] = arr[tree[2*i+1]] > arr[tree[2*i+2]]? tree[2*i+1]: tree[2*i+2];
    }

    int query(int i, int start, int end, int left, int right, int[] arr) {
        if(left > end || right < start) {
            return  -1;
        }

        if(left <= start && right >= end) {
            return tree[i];
        }

        int mid = start + (end - start)/2;
        int leftIndex = query(2*i+1, start, mid, left, right, arr);
        int rightIndex = query(2*i+2, mid+1, end, left, right, arr);

        if(leftIndex != -1 && rightIndex != -1) {
            if(arr[leftIndex] >= arr[rightIndex]) {
                return leftIndex;
            } else {
                return rightIndex;
            }
        } else if(leftIndex == -1) {
            return rightIndex;
        } else {
            return leftIndex;
        }
    }

    int binarySearch(int index, int maxheight, int[] heights) {
        int left = index+1;
        int right = n-1;
        int res = Integer.MAX_VALUE;

        while(left <= right) {
            int mid = left + (right - left)/2;

            int idx = query(0, 0, n-1, left, mid, heights);

            if(idx != -1 && heights[idx] > maxheight) {
                res = Math.min(idx, res);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res == Integer.MAX_VALUE? -1: res;
    }
}

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        int i = 0;
        SegmentTree st = new SegmentTree(heights);

        for(int[] x: queries) {
            int minIndex = Math.min(x[0], x[1]);
            int maxIndex = Math.max(x[0], x[1]);

            if(minIndex == maxIndex || heights[minIndex] < heights[maxIndex]) {
                result[i++] = maxIndex;
            } else {
                result[i++] = st.binarySearch(maxIndex, heights[minIndex], heights);
            }
        }

        return result;
    }
}
