// #1828. Queries on Number of Points Inside a Circle


class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans= new int[queries.length];
        int c= 0;
        for(int[] i: queries) {
            for(int[] j: points) {
                if(distance(i[0], i[1], j[0], j[1])<= i[2])
                    ans[c]++;
            }
            c++;
        }
        
        return ans;
    }
    
    double distance(int x1, int y1, int x2, int y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) +
                Math.pow(y2 - y1, 2) * 1.0);
    }
}
