class Solution {
    int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceMonth = Integer.parseInt((String) arriveAlice.subSequence(0, 2));
        int arriveAliceDate = Integer.parseInt((String) arriveAlice.subSequence(3, 5));
        int leaveAliceMonth = Integer.parseInt((String) leaveAlice.subSequence(0, 2));
        int leaveAliceDate = Integer.parseInt((String) leaveAlice.subSequence(3, 5));

        int arriveBobMonth = Integer.parseInt((String) arriveBob.subSequence(0, 2));
        int arriveBobDate = Integer.parseInt((String) arriveBob.subSequence(3, 5));
        int leaveBobMonth = Integer.parseInt((String) leaveBob.subSequence(0, 2));
        int leaveBobDate = Integer.parseInt((String) leaveBob.subSequence(3, 5));

        int aliceStart = solve(arriveAliceMonth) + arriveAliceDate;
        int aliceEnd = solve(leaveAliceMonth) + leaveAliceDate;
        int bobStart = solve(arriveBobMonth) + arriveBobDate;
        int bobEnd = solve(leaveBobMonth) + leaveBobDate;

        int max = Math.max(aliceStart, bobStart);
        int min = Math.min(aliceEnd, bobEnd);
        int total = min - max + 1;
        return total >= 0? total: 0;
    }

    private int solve(int arriveMonth) {
        int i = 0;
        int totalDays = 0;
        while (i < arriveMonth - 1) {
            totalDays += month[i];
            i++;
        }

        return totalDays;
    }
}
