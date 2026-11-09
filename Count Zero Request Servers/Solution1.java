class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int m = logs.length;
        int q = queries.length;
        int[] result = new int[q];
        int[][] arr = new int[q][2];
        for(int i=0;i<q;i++) {
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] a: arr) {
            int idx = a[1];
            int start = a[0] - x;
            int end = a[0];

            while(j < m && logs[j][1] <= end) {
                map.put(logs[j][0], map.getOrDefault(logs[j][0], 0) + 1);
                j++;
            }

            while(i < m && logs[i][1] < start) {
                map.put(logs[i][0], map.getOrDefault(logs[i][0], 0) - 1);
                if(map.get(logs[i][0]) == 0) {
                    map.remove(logs[i][0]);
                }
                i++;
            }

            result[idx] = n - map.size();
        }

        return result;
    }
}
