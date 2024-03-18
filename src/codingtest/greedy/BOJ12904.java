package codingtest.greedy;

import java.io.*;

public class BOJ12904 {
    private static int answer;
    private static String T;
    private static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        solve();
        System.out.println(answer);
    }

    private static void solve() {
        StringBuilder sb;
        while (S.length() < T.length()) {
            if (T.endsWith("A")) {
                T = T.substring(0,T.length() - 1);
            } else if (T.endsWith("B")) {
                sb = new StringBuilder(T.substring(0,T.length() - 1));
                T = sb.reverse().toString();
            }
        }
        if (S.equals(T))
            answer = 1;
        else
            answer = 0;
    }
}