package ProblemSolving.IOClasses;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static class FastIO {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;
        PrintStream out;

//        **** Fast I/O ****
//        BufferedReader for Input
//        PrintStream for Output

        public FastIO() throws FileNotFoundException {
            if (System.getProperty("ONLINE_JUDGE") == null) {
                bufferedReader = new BufferedReader(new FileReader("input.txt"));
                out = new PrintStream(new FileOutputStream("output.txt"));
                System.setOut(out);
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String helperNext() throws Exception {
            if (stringTokenizer == null) stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException exception) {
                    exception.printStackTrace(out);
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(helperNext());
        }

        long nextLong() throws Exception {
            return Long.parseLong(helperNext());
        }

        double nextDouble() throws Exception {
            return Double.parseDouble(helperNext());
        }

        String nextLine() throws IOException {
            if (stringTokenizer == null) stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException exception) {
                exception.printStackTrace(out);
            }
            return str;
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        FastIO fastIO = new FastIO();
        solution.helperFunction(fastIO);
    }

}

class Solution {
    public void helperFunction(Main.FastIO fastIO) throws Exception {
        //solution goes here
        var testCaseCount = fastIO.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            var input = fastIO.nextInt();
            generatePermutationOptimised(input);
        }
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
        System.out.println();
    }
}


