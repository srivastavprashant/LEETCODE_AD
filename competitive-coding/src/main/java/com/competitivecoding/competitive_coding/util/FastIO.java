package com.competitivecoding.competitive_coding.util;


import java.io.*;
import java.util.*;

public class FastIO {
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

