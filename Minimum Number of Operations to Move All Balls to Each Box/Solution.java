class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        int operations = 0;
        int box = 0;

        for(int i=0;i<n;i++) {
            ans[i] = operations;

            if(boxes.charAt(i) == '1') {
                box++;
            }

            operations += box;
        }

        box = 0;
        operations = 0;

        for(int i=n-1;i>=0;i--) {
            ans[i] += operations;

            if(boxes.charAt(i) == '1') {
                box++;
            }

            operations += box;
        }

        return ans;
    }
}
