class Solution {
    public int[] findEvenNumbers(int[] digits) {
        TreeSet<Integer> set = new TreeSet<>();
        int[] freq = new int[10];
        for(int ele: digits) {
            freq[ele]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0) {
                continue;
            }

            freq[i]--;
            for (int j = 0; j <= 9; j++) {
                if(freq[j] == 0) {
                    continue;
                }

                freq[j]--;
                for (int k = 0; k <= 8; k+= 2) {
                    if(freq[k] == 0) {
                        continue;
                    }
                    freq[k]--;
                    int num = i * 100 + j * 10 + k;
                        set.add(num);
                    freq[k]++;
                }

                freq[j]++;
            }

            freq[i]++;
        }
        int i = 0;
        int[] res = new int[set.size()];
        for (int ele : set) {
            res[i++] = ele;
        }

        return res;
    }
}
