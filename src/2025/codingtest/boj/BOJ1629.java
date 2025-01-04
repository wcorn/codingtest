package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        System.out.println(dfs(A, B, C));
    }

    private static long dfs(long A, long B, long C) {
        if (B == 0) {
            return 1;
        }
        long temp = dfs(A, B / 2, C);
        if (B % 2 == 1) {
            return ((temp * temp) % C * A) % C;
        }
        return temp * temp % C;
    }
}
