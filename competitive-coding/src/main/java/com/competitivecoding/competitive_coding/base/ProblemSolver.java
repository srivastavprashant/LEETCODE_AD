package com.competitivecoding.competitive_coding.base;

import com.competitivecoding.competitive_coding.util.FastIO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public abstract class ProblemSolver {
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


    public abstract void solve();

    public void run() throws IOException {
        solve();
        io.close();
    }
}
