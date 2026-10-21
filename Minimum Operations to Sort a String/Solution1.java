class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String str = new String(arr);
        if(s.equals(str)) {
            return 0;
        }

        if(n == 2) {
            return -1;
        }

        char minChar = arr[0];
        char maxChar = arr[n-1];
        if(s.charAt(0) == minChar || s.charAt(n-1) == maxChar) {
            return 1;
        }

        char minMid = arr[1];
        char maxMid = arr[n-2];

        if(s.charAt(0) > maxMid && s.charAt(n-1) < minMid) {
            return 3;
        }
        return 2;
    }
}
