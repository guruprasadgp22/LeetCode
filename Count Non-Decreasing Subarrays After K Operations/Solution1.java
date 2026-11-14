class Solution {
    int[] prefixSum;
    private int rangeSum(int i, int j) {
        return prefixSum[j] - (i > 0? prefixSum[i-1]: 0);
    }
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int NGR[] = new int[n];
        Arrays.fill(NGR, n);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                NGR[stack.pop()] = i;
            }
            stack.add(i);
        }

        int operations[] = new int[n+1];
        for(int i=n-1;i>=0;i--) {
            int m = NGR[i];
            int segOp = (nums[i] * (m - i)) - rangeSum(i, m-1);
            operations[i] = segOp + operations[m];
        }

        int i = 0;
        int j = 0;
        long result = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        while(j < n) {
            while(!dq.isEmpty() && nums[dq.getLast()] <nums[j]) {
                dq.pollLast();
            }

            dq.addLast(j);

            while(i <= j) {
                int m = dq.getFirst();
                int opCnt = operations[i] - operations[m] + (nums[m] * (j - m + 1)) - rangeSum(m, j);

                if(opCnt <= k) {
                    break;
                }
                i++;

                if(dq.getFirst() < i) {
                    dq.pollFirst();
                }
            }

            result += (j - i + 1);
            j++;
        }
        return result;
    }
}
