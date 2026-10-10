class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int ele: bills) {
            if(ele == 5) {
                five++;
            } else if(ele == 10) {
                ten++;
                if(five >= 1) {
                    five--;
                } else {
                    return false;
                }
            } else {
                if(ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else if(five >= 3 ){
                    five -= 3; 
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
