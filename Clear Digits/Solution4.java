class Solution {
    public String clearDigits(String s) {
        int i = 0;
        int j = 0;
        char[] arr = s.toCharArray();

        while(i < arr.length) {
            if(Character.isDigit(arr[i])) {
                if(j -1 >= 0) {
                    j--;
                }
            } else {
                arr[j] = arr[i];
                j++;
            }
            i++;
        }

        return new String(arr, 0, j);
    }
}
