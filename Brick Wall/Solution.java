class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(List<Integer> ls: wall) {
            int sum = 0;
            for(int i=0;i<ls.size()-1;i++) {
                sum += ls.get(i);

                map.put(sum, map.getOrDefault(sum , 0) + 1);
            }
        }
        int max = 0;
        for(int sum: map.values()) {
            max = Math.max(max, sum);
        }

        return wall.size() - max;
    }
}
