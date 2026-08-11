class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums) {
            set.add(ele);
        }

        int sum = 0;
        int num = nums[0];

        for(int ele: nums) {
            if(ele == num) {
                num++;
                sum += ele;
            } else {
                break;
            }
        }

        while(true) {
            if(set.contains(sum)) {
                sum++;
            } else {
                break;
            }
        }

        return sum;
    }
}
