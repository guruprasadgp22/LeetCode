class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele: arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        HashMap<Integer, Integer> mapping = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            mapping.put(entry.getValue(), mapping.getOrDefault(entry.getValue(), 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: mapping.entrySet()) {
            if(entry.getValue() > 1) {
                return false;
            }
        }

        return true;
    }
}
