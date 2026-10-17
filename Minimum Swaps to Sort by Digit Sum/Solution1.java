class Solution {
    private int getDigit(int num) {
        int sum = 0;

        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] temp = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int n1 = getDigit(a);
            int n2 = getDigit(b);

            if(n1 == n2) {
                return a - b;
            }

            return Integer.compare(n1, n2);
        });

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(nums[i], i);
        }

        int count = 0;
        for(int i=0;i<n;i++) {
            int currVal = nums[i];
            int expVal = temp[i];

            if(currVal == expVal) {
                continue;
            }

            int eIdx = map.get(expVal);
            nums[i] = expVal;
            nums[eIdx] = currVal;
            map.put(nums[i], i);
            map.put(nums[eIdx], eIdx);
            count++;
        }

        return count;
    }
}
