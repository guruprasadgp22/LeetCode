class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }

        Arrays.sort(arr, (a, b)->{
            return b[1] - a[1];
        });

        long kSum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<k;i++) {
            kSum += arr[i][0];
            queue.add(arr[i][0]);
        }

        long result = kSum * arr[k-1][1];

        for(int i=k;i<n;i++) {
            kSum += arr[i][0] - queue.poll();   
            queue.add(arr[i][0]);
            result = Math.max(result, kSum * arr[i][1]);
        }
        
        return result;
    }
}
