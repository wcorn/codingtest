package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1932"> 정수 삼각형 </a>
 */
public class BOJ1932 {

    private static int[][] dp;
    private static boolean[][] visited;
    private static int[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recursion(0, 0));
    }

    private static int recursion(int x, int y) {
        if (x >= n) {
            return 0;
        }
        if (visited[x][y]) {
            return dp[x][y];
        }
        dp[x][y] = Math.max(recursion(x + 1, y), recursion(x + 1, y + 1)) + map[x][y];
        visited[x][y] = true;
        return dp[x][y];
    }
}


