package com.competitivecoding.competitive_coding.leetcode.BestTimeToBuyAndSellStock_121;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock_121 extends ProblemSolver {
    @Override
    public void solve() {
/*
        Solve here: Create Solution Object for leet Code else others and run its respective function.
        Solution solution = new Solution();
        Use IO operations like Ex: io.println();
*/
        Solution solution = new Solution();
        var prices = Arrays.stream(io.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        io.println(solution.maxProfit(prices));

    }

    public static void main(String[] args) throws Exception {
        new BestTimeToBuyAndSellStock_121().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {
    public int maxProfit(int[] prices) {
        assert prices.length >= 1; // at least 1 value is provided.
        int maxProfit = 0;
        var minPriceIHaveSeenSoFar = prices[0];
        for (int currentPrice : prices) {
            var profitWithCurrentPrice = currentPrice - minPriceIHaveSeenSoFar;
            if (profitWithCurrentPrice > maxProfit) {
                maxProfit = profitWithCurrentPrice;
            }
            minPriceIHaveSeenSoFar = Math.min(minPriceIHaveSeenSoFar, currentPrice);
        }
        return maxProfit;
    }
}