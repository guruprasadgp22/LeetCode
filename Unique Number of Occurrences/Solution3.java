class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];

        for(int ele: arr) {
            count[ele + 1000]++;
        }

        Arrays.sort(count);
        for(int i=1;i<2001;i++) {
            if(count[i] != 0 && count[i] == count[i-1]) {
                return false;
            }
        }

        return true;
    }
}
