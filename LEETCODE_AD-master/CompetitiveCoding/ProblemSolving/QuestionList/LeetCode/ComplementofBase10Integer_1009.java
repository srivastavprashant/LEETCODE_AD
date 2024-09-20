package ProblemSolving.QuestionList.LeetCode;

import ProblemSolving.IOClasses.Main;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ComplementofBase10Integer_1009 {

    public int[] helperFunction(int[] dpArray, int n) {
        if (n == 0 || n == 1) {
            return dpArray;
        } else if (dpArray[n] != -1) {
            return dpArray;
        } else if (dpArray[n] == -1) {
            // System.out.printf(" %s -> %d \n","Calculation", n); //To prove its O(n);
            var bitSpecialOperationDigit = n & (n - 1);
            var previousRecordBit = helperFunction(dpArray, bitSpecialOperationDigit)[bitSpecialOperationDigit];
            dpArray[n] = 1 + previousRecordBit;
        }
        return dpArray;
    }


    public static void main(String[] args) throws Exception {
        Main.FastIO fastIO = new Main.FastIO();
        //Input
        var input = scanner.nextInt();
        //Solution Call
        var outputArray = new CountingBits_338().countBits(input);
        //Output
        for (int i = 0; i < input + 1; i++) { //+1 because we have increase +1 in countbits function
            System.out.printf(" %d -> %d \n ", i, outputArray[i]);
        }
    }
}
//To Match LeetCode
class Solution {
    public int bitwiseComplement(int n) {

    }
}


