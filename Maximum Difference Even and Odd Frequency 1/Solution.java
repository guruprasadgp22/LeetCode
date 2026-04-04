class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int odd = Integer.MIN_VALUE;
        int even = Integer.MAX_VALUE;

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int num = entry.getValue();
            if(num % 2 == 0) {
                even = Math.min(even, num);
            } else {
                odd = Math.max(odd, num);
            }
        }

        return odd- even;
    }
}
