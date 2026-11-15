class Solution {
    public int[] findEvenNumbers(int[] digits) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        set.add(num);
                    }
                }
            }
        }
        int i = 0;
        int[] res = new int[set.size()];
        for (int ele : set) {
            res[i++] = ele;
        }

        return res;
    }
}
