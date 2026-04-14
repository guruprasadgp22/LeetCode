class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if(arr.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> mapPattern = new HashMap<>();
        HashMap<String, Character> mapS = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            if(
                (mapPattern.containsKey(pattern.charAt(i)) 
                &&
                !mapPattern.get(pattern.charAt(i)).equals(arr[i]))
                ||
                (mapS.containsKey(arr[i]) 
                &&
                mapS.get(arr[i]) != pattern.charAt(i)
                )
            ) {
                return false;
            }

            mapS.put(arr[i], pattern.charAt(i));
            mapPattern.put(pattern.charAt(i), arr[i]);
        }

        return true;
    }
}
