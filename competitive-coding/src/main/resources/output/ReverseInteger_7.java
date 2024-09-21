import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;










abstract class ProblemSolver {
    protected static FastIO io;

    static {
        boolean ifPresentOnlineJudgeProperty = System.getProperties().containsKey("ONLINE_JUDGE"); //For Codeforces
        if(ifPresentOnlineJudgeProperty) {
            io = new FastIO();
        } else if (Objects.equals(System.getProperty("user.name"), "sriva")) { //For Local
            try {
                String resourcePath = "src/main/resources/";
                io = new FastIO(resourcePath + "input.txt", resourcePath + "output.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else { //For Else
            io = new FastIO();
        }
    }


    abstract void solve();

    public void run() throws IOException {
        solve();
        io.close();
    }
}


public class ReverseInteger_7 extends ProblemSolver {
    @Override
    public void solve() {
/*
        Solve here: Create Solution Object for leet Code else others and run its respective function.
        Solution solution = new Solution();
        Use IO operations like Ex: io.println();
*/
        Solution solution = new Solution();
        var input = io.nextInt();
        io.print(solution.reverse(input));

    }

    public static void main(String[] args) throws Exception {
        new ReverseInteger_7().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {
    public int reverse(int x) {
        var maxState = (Integer.MAX_VALUE / 10);
        var minState = (Integer.MIN_VALUE / 10);
        var solution = 0;
        while (x != 0) {
            var d = x % 10;
            if (solution > maxState || solution < minState) {
                return 0;
            }
            solution = solution * 10 + d;
            x /= 10;
        }
        return solution;
    }
}





class FastIO {
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    public FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    public FastIO(String inputFile, String outputFile) throws IOException {
        br = new BufferedReader(new FileReader(inputFile));
        out = new PrintWriter(new FileWriter(outputFile));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) out.print(' ');
            out.print(objects[i]);
        }
    }

    public void println(Object... objects) {
        print(objects);
        out.println();
    }

    public void close() throws IOException {
        br.close();
        out.close();
    }
}

