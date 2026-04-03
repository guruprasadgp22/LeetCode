class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        char ch = '1';
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() < 2) {
                ch = entry.getKey();
                break;
            }
        }
        if(ch == 1) {
            return -1;
        }
        return s.indexOf(ch);
    }
}
