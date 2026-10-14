class Solution {
    public int minLength(String s) {
        int n = s.length();
        int i = 0;
        int j = 1;
        char[] arr = s.toCharArray();

        while(j < n) {
            if(i < 0) {
                i++;
                arr[i] = arr[j];
            } else if((arr[i] == 'A' && arr[j] == 'B') || (arr[i] == 'C' && arr[j] == 'D')) {
                i--;
            } else {
                i++;
                arr[i] = arr[j];
            }
            j++;
        }

        return i+1;
    }
}
