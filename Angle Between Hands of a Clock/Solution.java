class Solution {
    public double angleClock(int hour, int minutes) {
        double hours = (hour % 12) * 30 + minutes * 0.5;
        double minute = minutes * 6;

        double diff = Math.abs(hours - minute);

        return Math.min(diff, 360 - diff);
    }
}
