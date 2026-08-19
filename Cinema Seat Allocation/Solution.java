class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int[] x: reservedSeats) {
            int row = x[0];
            int seatNo = x[1];

            map.computeIfAbsent(row, k -> new HashSet<>()).add(seatNo);
        }

        int result = (n-map.size())*2;

        for(Map.Entry<Integer, HashSet<Integer>> entry: map.entrySet()) {
            HashSet<Integer> set = entry.getValue();

            boolean grpA = !set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5);
            boolean grpB = !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7);
            boolean grpC = !set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9);

            if(grpA && grpC) {
                result += 2;
            } else if(grpA || grpB || grpC) {
                result += 1;
            }
        }

        return result;
    }
} 
