class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());

        list.sort((a, b) -> {
            return b.getValue() - a.getValue();
        });

        int[] arr = new int[k];
        for(int i=0;i<k;i++) {
            arr[i] = list.get(i).getKey();
        }

        return arr;
    }
}
