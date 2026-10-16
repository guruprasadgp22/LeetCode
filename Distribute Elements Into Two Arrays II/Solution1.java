class SegmentTree {
    int n;
    int[] tree;

    SegmentTree(int n) {
        this.n = n;
        tree = new int[4 * n];
    }

    void update(int compressedValueIndex) {
        update(0, 0, n - 1, compressedValueIndex);
    }

    void update(int i, int start, int end, int compressedValueIndex) {
        if (start == end) {
            tree[i] += 1;
            return;
        }

        int mid = start + (end - start) / 2;
        if (compressedValueIndex <= mid) {
            update(2 * i + 1, start, mid, compressedValueIndex);
        } else {
            update(2 * i + 2, mid + 1, end, compressedValueIndex);
        }

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    int query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    int query(int i, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && right >= end) {
            return tree[i];
        }

        int mid = start + (end - start) / 2;
        return query(2 * i + 1, start, mid, left, right) + query(2 * i + 2, mid + 1, end, left, right);
    }
}

class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: copy) {
            if(map.containsKey(ele)) {
                continue;
            }

            map.put(ele, i);
            i++;
        }

        int m = map.size();

        SegmentTree st1 = new SegmentTree(m);
        SegmentTree st2 = new SegmentTree(m);

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        st1.update(map.get(nums[0]));

        arr2.add(nums[1]);
        st2.update(map.get(nums[1]));

        for(i=2;i<n;i++) {
            int compressedValueIdx = map.get(nums[i]);
            int count1 = st1.query(compressedValueIdx+1, m-1);
            int count2 = st2.query(compressedValueIdx+1, m-1);

            if(count1 > count2) {
                st1.update(compressedValueIdx);
                arr1.add(nums[i]);
            } else if(count2 > count1) {
                st2.update(compressedValueIdx);
                arr2.add(nums[i]);
            } else {
                if(arr1.size() <= arr2.size()) {
                    st1.update(compressedValueIdx);
                    arr1.add(nums[i]);
                } else {
                    st2.update(compressedValueIdx);
                    arr2.add(nums[i]);
                }
            }
        }

        int[] result = new int[n];
        i = 0;

        for(int ele: arr1) {
            result[i++] = ele;
        }

        for(int ele: arr2) {
            result[i++] = ele;
        }

        return result;
    }
}
