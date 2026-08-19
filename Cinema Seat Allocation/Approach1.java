class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] x: reservedSeats) {
            int row = x[0];
            int seats = x[1];

            map.put(row, map.getOrDefault(row, 0) | (1 << seats));
        }
        int maskA = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int maskB = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int maskC = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        int result = (n-map.size())*2;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int mask = entry.getValue();

            boolean grpA = (mask & maskA) == 0;
            boolean grpB = (mask & maskB) == 0;
            boolean grpC = (mask & maskC) == 0;

            if(grpA && grpC) {
                result += 2;
            } else if(grpA || grpB || grpC) {
                result += 1;
            }
        }

        return result;
    }
}
