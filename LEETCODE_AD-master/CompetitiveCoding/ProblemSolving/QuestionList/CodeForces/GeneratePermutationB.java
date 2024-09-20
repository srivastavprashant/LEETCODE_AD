package ProblemSolving.QuestionList.CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class GeneratePermutationB {
//    Link :- https://codeforces.com/contest/2001/problem/B

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        var generatePermutationCallingObject = new GeneratePermutationB();
        for (int i = 0; i < testCaseCount; i++) {
            var input = scanner.nextInt();
            generatePermutationCallingObject.generatePermutationOptimised(input);
        }
    }

    public void generatePermutation(int n) {
        var arr = new int[n];

    }

    public void generatePermutationOptimised(int n) {
        // There is a pattern that even can never have this required Permutation. For Odd there is a pattern
        var arr = new int[n];
        if ((n & 1) == 0) {
            System.out.println(-1);
            return;
        }
        var leftPointer = 0;
        var rightPointer = n - 1;
        var isRightTurn = true;
        for (int i = 1; i <= n; i++) {
            if (leftPointer == rightPointer) {
                arr[leftPointer] = i;
                break;
            } else if (isRightTurn) {
                arr[rightPointer] = i;
                rightPointer--;
            } else {
                arr[leftPointer] = i;
                leftPointer++;
            }
            isRightTurn = !isRightTurn;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void generatePermutationBruteForce(int n) {
        var typeWriterArray1 = new int[n];
        var typeWriterArray2 = new int[n];

        for (int i = 0; i < factorial(n); i++) {
            Arrays.fill(typeWriterArray1, -1);
            Arrays.fill(typeWriterArray2, -1);
            checkForCondition(typeWriterArray1, typeWriterArray2);
        }
    }

    private void checkForCondition(int[] typeWriterArray1, int[] typeWriterArray2) {
        int cr1 = 0;
        int cr2 = 0;

    }

    public int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
