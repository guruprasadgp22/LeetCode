class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int start = low;start<=high;start++) {
            if(start >= 10 && start <= 99 && start % 11 == 0) {
                count++;
            } else if(start >= 1000 && start <= 9999) {
                int first = start/1000;
                int second = (start/100)%10;
                int third = (start/10)%10;
                int fourth = start % 10;

                if(first + second == third + fourth) {
                    count++;
                }
            }
        }

        return count;
    }
}
