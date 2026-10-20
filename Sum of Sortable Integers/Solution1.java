class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        
        int[] sortedArr = Arrays.copyOf(nums, n);
        Arrays.sort(sortedArr);
        
        int result = 0;
        for(int k=1;k<=n;k++) {
            if(n%k != 0) {
                continue;
            }

            boolean valid = true;
            for(int i=0;i<n;i+=k) {
                int[] arr1 = Arrays.copyOfRange(nums, i, i+k);
                int[] arr2 = Arrays.copyOfRange(sortedArr, i, i+k);

                if(!rotation(arr1, arr2)) {
                    valid = false;
                    break;
                }
            }

            if(valid) {
                result += k;
            }
        }

        return result;
    }

    private boolean rotation(int[] arr1, int[] arr2) {
        int m = arr2.length;
        int[] doubleArr2 = new int[2*m];
        System.arraycopy(arr2, 0, doubleArr2, 0, m);
        System.arraycopy(arr2, 0, doubleArr2, m, m);

        return KMPsearch(arr1, doubleArr2);
    }

    private boolean KMPsearch(int[] pat, int[] txt) {
        int m = pat.length;
        int n = txt.length;
        int[] LPS = new int[m];
        lps(pat, LPS);

        int i = 0;
        int j = 0;

        while(i < n) {
            if(pat[j] == txt[i]){
                i++;
                j++;
            }

            if(j == m) {
                return true;
            } else if(i < n && (j == 0 || pat[j] != txt[i])) {
                if(j != 0) {
                    j = LPS[j-1];
                } else {
                    i++;
                }
            }
        }

        return false;

    }

    private void lps(int[] pat, int[] LPS) {
        int m = pat.length;
        int i = 1;
        int len = 0;

        while(i < m) {
            if(pat[i] == pat[len]) {
                len++;
                LPS[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = LPS[len-1];
                } else {
                    i++;
                }
            }
        }
    }
}
