class Pair implements Comparable<Pair> {
    int val;
    int index;

    Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }

    public int compareTo(Pair o) {
        return o.val - this.val;
    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            queue.add(new Pair(score[i], i));
        }        

        String result[] = new String[n];
        int rank = 0;
        while(!queue.isEmpty()) {
            Pair temp = queue.poll();

            int index = temp.index;

            if(rank == 0) {
                result[index] = "Gold Medal";
            } else if(rank == 1) {
                result[index] = "Silver Medal";
            } else if(rank == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank + 1);
            }
            rank++;
        }

        return result;
    }
}
