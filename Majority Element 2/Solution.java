class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;
        int ele1 = -1;
        int ele2 = -1;

        for(int num: nums) {
            if(num ==ele1) {
                count1++;
            }else if(num == ele2) {
                count2++;
            } else if(count1 == 0) {
                ele1 = num;
                count1++;
            } else if(count2 == 0) {
                ele2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int ele: nums) {
            if(ele1 == ele) {
                count1++;
            } else if(ele2 == ele) {
                count2++;
            }
        }

        if(count1 > nums.length/3) {
            list.add(ele1);
        }
        
        if(count2 > nums.length/3) {
            list.add(ele2);
        }

        return list;
    }
}
