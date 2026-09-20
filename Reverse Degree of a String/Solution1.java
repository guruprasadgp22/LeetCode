class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        int i = 1;

        for(char ch: s.toCharArray()) {
            int idx = 'z' - ch + 1;
            total += idx * i;
            i++;
        }

        return total;
    }
}
