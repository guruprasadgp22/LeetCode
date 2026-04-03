class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length-1;

        while(left < right) {
            while(left < right && !(Character.toLowerCase(arr[left]) == 'a' || Character.toLowerCase(arr[left]) == 'e' || Character.toLowerCase(arr[left]) == 'o' || Character.toLowerCase(arr[left]) == 'i' || Character.toLowerCase(arr[left]) == 'u')) {
                left++;
            }

             while(right > left && !(Character.toLowerCase(arr[right]) == 'a' || Character.toLowerCase(arr[right]) == 'e' || Character.toLowerCase(arr[right]) == 'o' || Character.toLowerCase(arr[right]) == 'i' || Character.toLowerCase(arr[right]) == 'u')) {
                right--;
            }

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }
}
