class Solution {
    int MOD = 1_000_000_007;
    public int smallestUniqueSubarray(int[] nums) {
        int base = 0;
        for (int ele : nums) {
            base = Math.max(base, ele);
        }
        base++;

        int low = 1;
        int high = nums.length;
        int res = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (checks(nums, mid, base)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    private boolean checks(int[] arr, int size, int base) {
        HashMap<Long, Integer> map = new HashMap<>();
        int left = 0;
        long currNum = 0;
        int n = arr.length;
        long p = findPower(base, size-1);
        for (int right = 0; right < n; right++) {
            if (right - left + 1 > size) {
                currNum = (currNum - p * arr[left] % MOD + MOD) % MOD;
                left++;
            }

            currNum = (currNum * base % MOD + arr[right]) % MOD;

            if (right - left + 1 == size) {
                map.put(currNum, map.getOrDefault(currNum, 0) + 1);
            }
        }

        for (int val : map.values()) {
            if (val == 1) {
                return true;
            }
        }

        return false;
    }

    private long findPower(int a, int base) {
        if(base == 0) {
            return 1;
        }

        long half = findPower(a, base/2);
        long res = (half * half) % MOD;
        if(base % 2 == 1) {
            res = (res * a) % MOD;
        }

        return res;
    }
}
