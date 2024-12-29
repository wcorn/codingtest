package codingtest.dynamicprograming;

import java.io.*;
import java.util.*;

public class BOJ1932 {
    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        System.out.println(map[1][1]);
    }

    private static void solve() {
        for (int i = n ; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                map[i - 1][j] = Math.max(map[i][j], map[i][j + 1]) + map[i - 1][j];
            }
        }
    }
}