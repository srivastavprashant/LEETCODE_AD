package com.competitivecoding.competitive_coding.codeforces;


import org.springframework.stereotype.Component;

import java.io.IOException;
import com.competitivecoding.competitive_coding.base.ProblemSolver;
import java.util.HashMap;
import java.util.Map;

@Component
public class TwoSum extends ProblemSolver {

    @Override
    public void solve() {
        int n = io.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = io.nextInt();
        }
        int target = io.nextInt();

        int[] result = twoSum(nums, target);
        io.println("Indices: " + result[0] + " " + result[1]);
        io.println("Numbers: " + nums[result[0]] + " " + nums[result[1]]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) throws IOException {
        new TwoSum().run();
    }
}
