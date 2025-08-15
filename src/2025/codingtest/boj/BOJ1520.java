package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1520"> 내리막 길 </a>
 */
public class BOJ1520 {

    private static int M;
    private static int N;
    private static int[][] dp;
    private static int[][] map;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i],-1);
        }
        dp[0][0] = 1;
        System.out.println(recursion(M - 1, N - 1));
    }

    private static int recursion(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                continue;
            }
            if (map[x][y] >= map[nextX][nextY]) {
                continue;
            }
            sum += recursion(nextX, nextY);
        }

        return dp[x][y] = sum;
    }
}
