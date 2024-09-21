package com.competitivecoding.competitive_coding.leetcode.SingleNumber_136;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

import java.util.Arrays;

public class SingleNumber_136 extends ProblemSolver {
    @Override
    public void solve() {
        //solve here: Create Solution Object for leet Code else others and run its respective function.
//        Solution solution = new Solution();
//        Use io Ex: io.println();
        Solution solution = new Solution();
        var input = io.nextLine();
        var nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        io.print(solution.singleNumber(nums));


    }

    public static void main(String[] args) throws Exception {
        new SingleNumber_136().run();
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = nums[i] ^ ans;
        }
        return ans;
    }
}

/*
 This below is a little slower than above due to use of ans variable in above

class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i + 1] = nums[i] ^ nums[i + 1];
        }
        return nums[nums.length - 1];
    }
}
*/
/*
This is O(n2) solution which is slower than above two but done for i, j will run from i+1, thus slicing array by 1 size
Commented above as this property be used in optimization(not here).
class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            var iElement = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (iElement == nums[j]) {
                    nums[i] = -1;
                    nums[j] = -1;
                    break;
              }
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != -1){
                return nums[i];
            }
        }
        return -1;
    }
}
*/
