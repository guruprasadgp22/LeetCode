class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long total = mass;
        for(int ele: asteroids) {
            if(total < ele) {
                return false;
            }

            total +=ele;
        }

        return true;
    }
}
