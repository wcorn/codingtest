package codingtest.dynamicprograming;

import java.io.*;
import java.util.*;

public class BOJ11660 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] dp;
    private static Queue<surface> q;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];
        q = new LinkedList<>();
        sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(new surface(Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1));
        }
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        calculate();
        surface temp;
        while (!q.isEmpty()) {
            temp = q.poll();
            sb.append(dp[temp.x2 - 1][temp.y2 - 1] - dp[temp.x1 - 2][temp.y2 - 1]- dp[temp.x2 - 1][temp.y1 - 2] + dp[temp.x1 - 2][temp.y1 - 2]).append("\n");
        }
    }

    private static void calculate() {
        dp[1][1] = map[1][1];

        for (int i = 2; i < N + 1; i++) {
            dp[i][1] = map[i][1] + dp[i - 1][1];
            dp[1][i] = map[1][i] + dp[1][i - 1];
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 2; j < N + 1; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] + map[i][j] - dp[i - 1][j - 1];
            }
        }
    }

    private static class surface {
        int x1;
        int x2;
        int y1;
        int y2;

        public surface(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }
}
