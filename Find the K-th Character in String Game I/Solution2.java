class Solution {
    public char kthCharacter(int k) {
        return (char)(Integer.bitCount(k-1) + 'a');
    }
}
