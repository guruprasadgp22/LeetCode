class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int Ax1 = rec1[0];
        int Ay1 = rec1[1];
        int Ax2 = rec1[2];
        int Ay2 = rec1[3];
        int Bx1 = rec2[0];
        int By1 = rec2[1];
        int Bx2 = rec2[2];
        int By2 = rec2[3];

        return Ax1 < Bx2 && Ax2 > Bx1 && Ay1 < By2 && Ay2 > By1;
    }
}
