class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;

        for(String s: logs) {
            if(s.equals("./")) {
                depth = depth;
            } else if(s.equals("../")) {
                if(depth > 0) {
                    depth--;
                } else {
                    depth = 0;
                }
            } else {
                depth++;
            }
        }

        return depth;
    }
}
