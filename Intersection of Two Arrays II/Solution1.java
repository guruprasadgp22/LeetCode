class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums1) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for(int ele: nums2){
            if(map.containsKey(ele) && map.get(ele) > 0) {
                ans.add(ele);
                map.put(ele, map.getOrDefault(ele, 0) - 1);
            }
        }

        int[] result  = new int[ans.size()];
        int i = 0;
        for(int ele: ans) {
            result[i++] = ele;
        }

        return result;
    }
}
