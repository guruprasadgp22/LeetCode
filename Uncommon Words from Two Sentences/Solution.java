class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String arr2[] = s2.split(" ");

        HashMap<String, Integer> map1 = new HashMap<>();
        for(String str: arr1) {
            map1.put(str, map1.getOrDefault(str, 0) + 1);
        }

        HashMap<String, Integer> map2 = new HashMap<>();
        for(String str: arr2) {
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }

        HashSet<String> ans = new HashSet<>();
        for(Map.Entry<String, Integer> entry: map1.entrySet()) {
            if(entry.getValue() == 1 && !map2.containsKey(entry.getKey())) {
                ans.add(entry.getKey());
            }
        }

        for(Map.Entry<String, Integer> entry: map2.entrySet()) {
            if(entry.getValue() == 1 && !map1.containsKey(entry.getKey())) {
                ans.add(entry.getKey());
            }
        }

        String[] res = new String[ans.size()];

        int i=0;
        for(String str: ans) {
            res[i++] = str;
        }

        return res;
    }
}
