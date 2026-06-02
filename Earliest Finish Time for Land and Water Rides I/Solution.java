class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land = Integer.MAX_VALUE;
        int water = Integer.MAX_VALUE;
        int landWater = Integer.MAX_VALUE;
        int waterLand = Integer.MAX_VALUE;
        int m = landDuration.length;
        int n = waterDuration.length;

        for(int i=0;i<m;i++) {
            land = Math.min(landStartTime[i]+landDuration[i], land);
        }

        for(int i=0;i<n;i++) {
            water = Math.min(waterStartTime[i] + waterDuration[i], water);
            landWater = Math.min(landWater, Math.max(waterStartTime[i], land) + waterDuration[i]);
        }

        for(int i=0;i<m;i++) {
            waterLand = Math.min(waterLand, Math.max(landStartTime[i], water) + landDuration[i]);
        }

        return Math.min(landWater, waterLand);
    }
}
