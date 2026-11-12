class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int[] x: dominoes) {
            if(x[0] > x[1]) {
                int t = x[0];
                x[0] = x[1];
                x[1] = t;
            }
            String s = x[0] + "_" + x[1];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for(int ele: map.values()) {
            if(ele > 1) {
                count += getValue(ele);
            }
        }

        return count;
    }

    private int getValue(int ele) {
        return (ele * (ele - 1))/2;
    }
}
