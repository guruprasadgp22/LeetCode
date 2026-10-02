class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> ls : knowledge) {
            map.put(ls.get(0), ls.get(1));
        }

        StringBuilder res = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int j = i + 1;

                while (j < s.length() && s.charAt(j) != ')') {
                    j++;
                }

                String sub = s.substring(i + 1, j);
                res.append(map.getOrDefault(sub, "?"));
                i = j + 1;
            } else {
                res.append(s.charAt(i));
                i++;
            }
        }

        return res.toString();
    }
}
