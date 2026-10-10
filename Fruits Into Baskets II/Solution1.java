class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        boolean[] visited = new boolean[n];
        int result = 0;
        for(int i=0;i<n;i++) {
            int first = fruits[i];
            boolean gotBasket = false;
            for(int j=0;j<n;j++) {
                if(first <= baskets[j] && !visited[j]) {
                    visited[j] = true;
                    gotBasket = true;
                    break;
                }
            }

            if(!gotBasket) {
                result++;
            }
        }

        return result;
    }
}
