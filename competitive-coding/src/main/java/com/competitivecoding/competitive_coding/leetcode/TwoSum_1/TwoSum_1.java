package com.competitivecoding.competitive_coding.leetcode.TwoSum_1;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

import java.util.*;

public class TwoSum_1 extends ProblemSolver {
    @Override
    public void solve() {
        //solve here: Create Solution Object for leet Code else others and run its respective function.
//        Solution solution = new Solution();
//        Use io Ex: io.println();
        Solution solution = new Solution();
        int[] nums = Arrays.stream(io.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = io.nextInt();
        var array = Arrays.stream(solution.twoSum(nums, target)).toArray();
        io.print(Arrays.toString(array));

    }

    public static void main(String[] args) throws Exception {
        new TwoSum_1().run();
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            var iElement = nums[i];
            if (map.containsKey(target - iElement) && map.get(target - iElement) != i) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
        }
        return result;
    }
}