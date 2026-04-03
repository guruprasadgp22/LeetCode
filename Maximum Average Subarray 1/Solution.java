class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 0) {
            return false;
        }
        
        int count = 0;
        if(count == n) {
            return true;
        }
        

        for(int i=0;i<flowerbed.length;i++) {
            if(flowerbed[i] == 0) {
                if((i==0 || flowerbed[i-1] == 0) && (i==flowerbed.length-1 || flowerbed[i+1] == 0)) {
                    flowerbed[i] = 1;
                    count++;
                }
                if(count == n) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
