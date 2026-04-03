class Solution {
    public int majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int ele1 = -1;
        int ele2 = -1;

        for(int ele: nums) {
            if(ele == ele1) {
                count1++;
            } else if(ele == ele2) {
                count2++;
            } else if(count1 == 0) {
                ele1 = ele;
                count1++;
            } else if(count2 == 0) {
                ele2 = ele;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int ele: nums) {
            if(ele == ele1) {
                count1++;
            } else if(ele == ele2) {
                count2++;
            }
        }

        int ans = -1;

        if(count1 < count2 && count2 > nums.length/2) {
            ans = ele2;
        } else if(count1 > nums.length/2){
            ans = ele1;
        }

        return ans;
    }
}
