class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int[] seat = new int[101];
        int[] student = new int[101];
        for(int ele: seats){
            seat[ele]++;
        }

        for(int ele: students){
            student[ele]++;
        }

        int i = 0;
        int j = 0;
        int total = 0;
        int n = seats.length;

        while(n > 0){
            if(seat[i] == 0) {
                i++;
            }

            if(student[j] == 0){
                j++;
            }

            if(seat[i] != 0 && student[j] != 0){
                total += Math.abs(i - j);
                seat[i]--;
                student[j]--;
                n--;
            }
        }

        return total;
    }
}
