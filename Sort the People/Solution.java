class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>();

        for(int i=0;i<heights.length;i++) {
            map.put(heights[i], names[i]);
        }

        int i=names.length-1;
        for(Map.Entry<Integer, String> entry: map.entrySet()) {
            names[i] = entry.getValue();
            i--;
        }

        return names;
    }
}
