class Solution {
    public int findComplement(int num) {
        int i = 0;
        int complement = 0;

        while(num > 0) {
            if((num & 1) == 0) {
                complement |= (1 << i);
            }

            num >>= 1;
            i++;
        }

        return complement;
    }
}
