class Solution {
    public int minFlips(int a, int b, int c) {
        int d = a & b;
        int e = (a | b) ^ c;
        int f = d & e;
        return Integer.bitCount(e) + Integer.bitCount(f);
    }
}
