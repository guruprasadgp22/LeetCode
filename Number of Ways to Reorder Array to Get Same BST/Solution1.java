class Solution {
    int MOD = 1_000_000_007;
    int[][] traingle;

    private void pascalTraingle() {
        for (int i = 2; i < traingle.length; i++) {
            for (int j = 1; j < i; j++) {
                traingle[i][j] = (traingle[i - 1][j] + traingle[i - 1][j - 1]) % MOD;
            }
        }
    }

    public int numOfWays(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        traingle = new int[n + 1][n + 1];
        for (int[] x : traingle) {
            Arrays.fill(x, 1);
        }

        pascalTraingle();
        return (solve(arr) - 1 + MOD)%MOD;
    }

    private int solve(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n <= 2) {
            return 1;
        }

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        int root = arr.get(0);
        for (int i = 1; i < n; i++) {
            if (arr.get(i) < root) {
                leftArr.add(arr.get(i));
            } else {
                rightArr.add(arr.get(i));
            }
        }

        long x = solve(leftArr);
        long y = solve(rightArr);
        long z = traingle[n - 1][leftArr.size()];

        return (int)((x * y % MOD * z) % MOD);
    }
}
