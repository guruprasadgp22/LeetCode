class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int m = g.length;
        int n = s.length;
        int count = 0;

        while(i < m && j < n) {
            if(s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }

        return count;
    }
}
