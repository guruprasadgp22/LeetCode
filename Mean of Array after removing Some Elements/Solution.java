class Solution {
    public double trimMean(int[] arr) {
        int perc = (5 * arr.length)/100;
        Arrays.sort(arr);

        int sum = 0;

        for(int i = perc; i <arr.length-perc;i++) {
            sum += arr[i];
        }

        double mean = (double)sum / (arr.length - perc - perc);

        return mean;
    }
}
