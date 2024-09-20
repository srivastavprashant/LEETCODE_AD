package ProblemSolving.QuestionList.LeetCode;

//Question Link
//https://leetcode.com/problems/number-of-1-bits/description/

import java.util.Scanner;

public class Numberof1Bits_191 {
    public int hammingWeight(int n) {
        var counter = 0;
        while (n > 0) {
            var extractedBit = n & 1; // AND with 1 gives most right bit
            n = n >> 1; // Shifting bit by 1 bit to go for next bit.
            counter += extractedBit; // if extracted bit is 1, obviously add 1, but if extracted bit is 0 we can either reject adding or add 0 as adding 0 makes no sense.
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        System.out.println(new Numberof1Bits_191().hammingWeight(inputNumber));
    }
}
