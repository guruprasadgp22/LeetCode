class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int evel = 0;
        int sum = 0;

        for(int i=0;i<requests.length;i++) {
            int temp = Math.abs(evel - requests[i]);
            evel = requests[i];

            sum += temp;
        }

        return sum;
    }
}
