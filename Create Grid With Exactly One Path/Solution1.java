class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];
        String topRow = ".".repeat(n);
        String rem = "#".repeat(n-1) + ".";
        result[0] = topRow;
        for(int i=1;i<m;i++) {
            result[i] = rem;
        }

        return result;
    }
}
