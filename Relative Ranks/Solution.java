class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] original = new int[n][2];

        for(int i=0;i<n;i++) {
            original[i][0] = score[i];
            original[i][1] = i;
        }

        for(int i=n/2-1;i>=0;i--) {
            heapify(original, n, i);
        }

        for(int i=n-1;i>=0;i--) {
            swap(original, 0, i);
            heapify(original, i, 0);
        }

        int count = 4;
        String[] arr = new String[n];
        for(int i=0;i<n;i++) {
            int index = original[i][1];

            if(i == 0) {
                arr[index] = "Gold Medal";
            } else if(i == 1) {
                arr[index] = "Silver Medal";
            } else if(i == 2) {
                arr[index] = "Bronze Medal";
            } else {
                arr[index] = String.valueOf(count);
                count++;
            }
        }
        return arr;
    }

    public void heapify(int arr[][], int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 *  i + 2;

        if(left < n && arr[left][0] < arr[smallest][0]) {
            smallest = left;
        }

        if(right < n && arr[right][0] < arr[smallest][0]) {
            smallest = right;
        }

        if(i != smallest) {
            swap(arr, i, smallest);
            heapify(arr, n, smallest);
        }
    }

    public void swap(int[][] arr, int i, int j) {
        int temp[] = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
