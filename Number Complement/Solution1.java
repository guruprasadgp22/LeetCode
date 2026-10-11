class Solution {
    public int findComplement(int num) {
        int bitCount = (int)(Math.log(num)/Math.log(2)) +1;
        int xor = 1;

        for(int i=0;i<bitCount;i++) {
            num ^= xor;
            xor = (xor << 1);
        }

        return num;
    }
}
