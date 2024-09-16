package LeetCodeJ;// #2087. Minimum Cost Homecoming of a Robot in a Grid


class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int minRow = Math.min(startPos[0], homePos[0]);
        int maxRow = Math.max(startPos[0], homePos[0]);
        int minCol = Math.min(startPos[1], homePos[1]);
        int maxCol = Math.max(startPos[1], homePos[1]);
        
        return calculate(minRow, maxRow, rowCosts) + calculate(minCol, maxCol, colCosts) - (rowCosts[startPos[0]] + colCosts[startPos[1]]);
    }
    
    public int calculate(int start, int destination, int[] cost) {
        int ans = cost[start];
        while(start != destination) {
            start++;
            ans += cost[start];
        }
        
        return ans;
    }
}
