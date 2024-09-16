package LeetCodeP.IOClasses;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static class FastIO {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;
        PrintStream out;

//        **** Fast I/O ****
//        BufferedReader for Input
//        PrintStream for Output

        public FastIO() throws FileNotFoundException {
            bufferedReader = new BufferedReader(new FileReader("input.txt"));
            out = new PrintStream(new FileOutputStream("output.txt"));
            System.setOut(out);
        }

        String helperNext() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException exception) {
                    exception.printStackTrace(out);
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(helperNext());
        }

        long nextLong() {
            return Long.parseLong(helperNext());
        }

        double nextDouble() {
            return Double.parseDouble(helperNext());
        }

        String nextLine() {
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
        FastIO fastIO = new FastIO();
        System.setOut(fastIO.out);

        var solution = new Solution();
        solution.helperFunction(fastIO);
    }
}
class Solution{
    public void helperFunction(Main.FastIO fastIO){
        //solution goes here
        String fullLine = fastIO.nextLine();
        var inputString = fullLine.split(" ");
        Arrays.sort(inputString);//nlogn
        Integer length = inputString.length;
        StringBuilder prefixString = new StringBuilder();
        int firstStringLength = inputString[0].length();// FLOWER FLOW
        //O(n2)
        var firstString = inputString[0];
        var lastString = inputString[length-1];
        var minimum = Math.min(firstString.length() , lastString.length());
        for(int i=0; i< firstStringLength ;i++){
            if(firstString.charAt(i) == lastString.charAt(i));
            else
            {
                break;
            }

        }

    }
}


