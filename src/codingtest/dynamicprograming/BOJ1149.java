package codingtest.dynamicprograming;

import java.util.*;
import java.io.*;

public class BOJ1149 {

    private static int[][] memo = new int[1001][3];
    private static int N;
    private static int[][] arr = new int[1001][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 3; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(solve(arr, N));
    }

    private static int dp(int index, int color) {
        if (index == N) return 0;

        if (memo[index][color] != -1) return memo[index][color];

        int ret = 0;
        for (int i = 0; i < 3; ++i) {
            if (i == color) continue;
            ret += dp(index + 1, i) + arr[index + 1][i];
        }

        memo[index][color] = ret;

        return ret;
    }

    private static int solve(int[][] arr, int N) {
        int answer = Integer.MAX_VALUE;
        for (int c = 0; c < 3; ++c) {
            answer = Math.min(answer, dp(0, c) + arr[0][c]);
        }
        return answer;
    }
}
