class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x[]: nums1) {
            map.put(x[0], x[1]);
        }

        for(int[] x: nums2) {
            if(map.containsKey(x[0])) {
                int val = map.get(x[0]);
                map.put(x[0], val + x[1]);
            } else {
                map.put(x[0], x[1]);
            }
        } 
        int i = 0;
        int[][] result = new int[map.size()][2];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }

        Arrays.sort(result, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        return result;
    }
}
