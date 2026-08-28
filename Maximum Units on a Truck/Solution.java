class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
         bubble_Sort(boxTypes);
         int ans = 0;

         for(int[] x: boxTypes) {
            int noOfBoxes = x[0];
            int unit  = x[1];
                        System.out.println(truckSize + " : " + ans);

            if(noOfBoxes <= truckSize) {
                ans += (unit * noOfBoxes);
                truckSize -= noOfBoxes;
            } else {
                ans += (unit * (truckSize > 0? truckSize: 0));
                truckSize = 0;
            }
         }

         return ans;
    }

    private void bubble_Sort(int[][] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j][1] < arr[j+1][1]) {
                    int[] temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
