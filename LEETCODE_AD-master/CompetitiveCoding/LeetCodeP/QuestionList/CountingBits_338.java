package LeetCodeP.QuestionList;

import java.util.Arrays;
import java.util.Scanner;

public class CountingBits_338 {
    //Solution 1: It can be done through by taking each number and checking its bits and then right shift 1 bit at a time. Max will be 32 bits.

    //Solution 2 : It can be done through n & n-1. Worst case is still same, but it will reduce to computation to number of 1's in digit.

    //Solution 3 : It can be done through DP and recursion by providing initial values of 1 2 and 3. Also by just 0 and 1 initial values. These two will require array of n size.
    //Done using DP and n&n-1
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[1];
        }
        var dpArray = new int[n + 1];
        Arrays.fill(dpArray, -1);
        dpArray[0] = 0;
        dpArray[1] = 1;
        for (int i = dpArray.length - 1; i > 1; i--) {
            helperFunction(dpArray, i);
        }
        return dpArray;
    }

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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
