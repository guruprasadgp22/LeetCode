class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch: s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());

        list.sort((a,b) -> {
            return b.getValue() - a.getValue();
        });

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character, Integer> entry: list) {
            int count = entry.getValue();

            while(count-- > 0) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
