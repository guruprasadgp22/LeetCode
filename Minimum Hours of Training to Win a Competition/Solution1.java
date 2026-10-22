class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int totalEnergy = 0;
        for (int ele : energy) {
            totalEnergy += ele;
        }

        int hours = Math.max(0, totalEnergy - initialEnergy + 1);
        for (int ele : experience) {
            if (initialExperience <= ele) {
                int diff = ele - initialExperience + 1;
                hours += diff;
                initialExperience += diff;
            }
            initialExperience += ele;

        }

        return hours;
    }
}
