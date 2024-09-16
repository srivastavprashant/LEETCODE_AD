package LeetCodeJ;

class Solution {
    public double angleClock(int hour, int minutes) {
        double angle= 360d/(60*12);
        double hangle= (hour%12* 60+ minutes)* angle;
        double mangle= minutes* 6;
        // System.out.println(hangle+" "+mangle);
        double ans= Math.abs(hangle-mangle);
        return Math.min(ans, 360-ans);
    }
}
