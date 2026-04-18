class Solution {
    public int findLucky(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int ele: arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int max = -1;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getKey().equals(entry.getValue())) {
                max = entry.getKey();
            }
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return max;
    }
}
