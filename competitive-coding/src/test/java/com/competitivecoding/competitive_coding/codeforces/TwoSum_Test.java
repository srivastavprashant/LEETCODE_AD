package com.competitivecoding.competitive_coding.codeforces;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
public class TwoSum_Test {
    @Autowired
    private TwoSum twoSum;

    @Test
    void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        assertArrayEquals(expected, twoSum.twoSum(nums, target));
    }

    @Test
    void testTwoSumNoSolution() {
        int[] nums = {1, 2, 3, 4};
        int target = 10;
        try {
            twoSum.twoSum(nums, target);
        } catch (IllegalArgumentException e) {
            assert (e.getMessage().equals("No two sum solution"));
        }
    }
}
