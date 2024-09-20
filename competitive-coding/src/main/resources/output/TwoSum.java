import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;














abstract class ProblemSolver {
    protected static FastIO io;

    static {
        boolean ifPresentOnlineJudgeProperty = System.getProperties().containsKey("ONLINE_JUDGE");
        if(ifPresentOnlineJudgeProperty) {
            io = new FastIO();
        } else if (Objects.equals(System.getProperty("user.name"), "")) {
            try {
                String resourcePath = "src/main/resources/";
                io = new FastIO(resourcePath + "input.txt", resourcePath + "output.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            io = new FastIO();
        }
    }


    abstract void solve();

    public void run() throws IOException {
        solve();
        io.close();
    }
}




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

