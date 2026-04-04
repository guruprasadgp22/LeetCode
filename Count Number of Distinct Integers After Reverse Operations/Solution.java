class Solution {
    public int countDistinctIntegers(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int ele: nums) {
            set.add(ele);
            int ans = reverse(ele);
            set.add(ans);
        }

        return set.size();
    }

    public int reverse(int num) {
        int res = 0;

        while(num > 0) {
            int temp = num % 10;
            res = res * 10 + temp;
            num /= 10;
        }
        return res;
    }
}
