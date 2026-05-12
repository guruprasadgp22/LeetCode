class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            set.add(ch);
        }

        String ans = "";
        for(char ch: order.toCharArray()) {
            if(!map.containsKey(ch)) {
                continue;
            }
            int count = map.get(ch);
            while(count > 0) {
                ans += String.valueOf(ch);
                count--;
            }

            set.remove(ch);
        }

        for(char ch: set) {
            int count = map.get(ch);
            while(count > 0) {
                ans += String.valueOf(ch);
                count--;
            }
        }

        return ans;
    }
}
