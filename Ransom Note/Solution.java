class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch: magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> ransMap = new HashMap<>();
        for(char ch: ransomNote.toCharArray()) {
            ransMap.put(ch, ransMap.getOrDefault(ch, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: ransMap.entrySet()) {
            if(map.containsKey(entry.getKey())) {
                int magVal = map.get(entry.getKey());
                if(entry.getValue() > magVal) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
