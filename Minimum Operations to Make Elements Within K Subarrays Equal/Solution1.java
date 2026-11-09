class Solution {
    int k;
    int n;
    int x;
    long[] cost;
    long[][] dp;

    void build(int[] arr) {
        cost = new long[1000001];
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        long leftSum = 0;
        long rightSum = 0;
        int i = 0;
        int j = 0;
        int leftSize = 0;
        int rightSize = 0;

        while(j < n) {
            if(leftSize <= rightSize) {
                add(left, arr[j]);
                leftSize++;
                leftSum += arr[j];
            } else {
                add(right, arr[j]);
                rightSize++;
                rightSum += arr[j];
            }

            if(leftSize > 0 && rightSize > 0) {
                int leftMax = left.lastKey();
                int rightMin = right.firstKey();

                if(leftMax > rightMin) {
                    remove(left, leftMax);
                    remove(right, rightMin);

                    add(left, rightMin);
                    add(right, leftMax);

                    leftSum += rightMin - leftMax;
                    rightSum += leftMax - rightMin;
                }
            }

            if(j - i + 1 == x) {
                long median = left.lastKey();
                cost[i] = (median * leftSize - leftSum) + (rightSum - median * rightSize);

                if(left.containsKey(arr[i])) {
                    remove(left, arr[i]);
                    leftSize--;
                    leftSum -= arr[i];
                } else {
                    remove(right, arr[i]);
                    rightSize--;
                    rightSum -= arr[i];
                }
                i++;
            }
            j++;
        }
    }

    void add(TreeMap<Integer, Integer> map, int ele) {
        map.put(ele, map.getOrDefault(ele, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int ele) {
        int freq = map.get(ele);
        if(freq == 1) {
            map.remove(ele);
        } else {
            map.put(ele, freq - 1);
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        this.k = k;
        n = nums.length;
        this.x = x;
        build(nums);

        dp = new long[k+1][n+1];
        for(long[] y: dp) {
            Arrays.fill(y, -1);
        }
        return solve(0, 0);    
    }

    private long solve(int count, int i) {
        if(count == k) {
            return 0;
        }

        if(dp[count][i] != -1) {
            return dp[count][i];
        }

        int subArrayNeed = k - count;
        int elementNeeded = subArrayNeed * x;
        int lastIndex = i + elementNeeded - 1;
        if(lastIndex >= n) {
            return Long.MAX_VALUE;
        }

        long take = cost[i] + solve(count + 1, i + x);
        long skip = solve(count, i+ 1);
        return dp[count][i] = Math.min(take, skip);
    }
}
