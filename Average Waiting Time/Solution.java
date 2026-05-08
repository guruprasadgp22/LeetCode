class Solution {
    public double averageWaitingTime(int[][] customers) {
        long currentTime = 0;
        long totalTime = 0;

        for(int i=0;i<customers.length;i++) {
            int arrival = customers[i][0];
            int prep = customers[i][1];

            currentTime = Math.max(currentTime, arrival);

            currentTime += prep;

            totalTime += currentTime - arrival;
        }

        return (double) totalTime/customers.length;
    }
}
