class Solution {
    String s;
    int n;
    int idx;
    public List<String> braceExpansionII(String expression) {
        s = expression;
        n = s.length();
        idx = 0;

        Set<String> st = performUnion();
        List<String> result = new ArrayList<>();
        result.addAll(st);

        result.sort((a, b) -> {
            return a.compareTo(b);
        });

        return result;
    }

    private Set<String> performUnion() {
        Set<String> result = new HashSet<>();

        while(true) {
            Set<String> temp = peformCon();
            result.addAll(temp);
            if(idx < n && s.charAt(idx) == ',') {
                idx++;
            } else {
                break;
            }
        }

        return result;
    }

    private Set<String> peformCon() {
    Set<String> result = new HashSet<>();
        result.add("");

        while(idx < n && (s.charAt(idx) == '{' || Character.isAlphabetic(s.charAt(idx)))) {
            Set<String> temp = getUnit();
            Set<String> conRes = new HashSet<>();
            for(String r: result){
                for(String l: temp) {
                    conRes.add(r + l);
                }
            }

            result = conRes;
        }

        return result;
    }

    private Set<String> getUnit() {
        Set<String> result = new HashSet<>();
        if(s.charAt(idx) == '{') {
            idx++;
            result = performUnion();
        } else {
            result.add(String.valueOf(s.charAt(idx)));
        }
        idx++;
        return result;
    }
}
