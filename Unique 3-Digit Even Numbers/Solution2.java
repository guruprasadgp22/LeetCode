class Solution {
    public int totalNumbers(int[] digits) {
        int result = 0;

        int freq[] = new int[10];
        for(int ele: digits) {
            freq[ele]++;
        }

        for(int i=1;i<=9;i++) {
            if(freq[i] == 0) {
                continue;
            }

            freq[i]--;

            for(int j=0;j<=9;j++) {
                if(freq[j] == 0) {
                    continue;
                }

                freq[j]--;

                for(int k=0;k<=8;k+=2){
                    if(freq[k] == 0) {
                        continue;
                    }
                    freq[k]--;
                    result++;
                    freq[k]++;
                }

                freq[j]++;
            }

            freq[i]++;
        }

        return result;
    }
}
