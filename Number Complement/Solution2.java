class Solution {
    public int findComplement(int num) {
        int bitCount = (int)(Math.log(num)/Math.log(2)) + 1;
        int xor = (1 << bitCount);
        return xor - num - 1;
    }
}
