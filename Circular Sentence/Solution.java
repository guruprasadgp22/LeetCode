class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        char ch = arr[0].charAt(arr[0].length()-1);
        char first = arr[0].charAt(0);
        for(int i=1;i<arr.length;i++) {
            if(ch != arr[i].charAt(0)) {
                return false;
            }
            ch = arr[i].charAt(arr[i].length()-1);
        }
        if(ch != first) {
            return false;
        }
        return true;
    }
}
