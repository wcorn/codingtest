package codingtest.dynamicprograming;

import java.util.*;
import java.io.*;

public class BOJ1149 {
    private static int N;
    private static int[][] house;
    private static int[][] color;
    private static int[] da = {1, 0, 0};
    private static int[] db = {2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        house = new int[N][3];
        color = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(getMin());
    }

    private static int getMin() {
        int min;
        min = Math.min(color[N - 1][0], color[N - 1][1]);
        min = Math.min(color[N - 1][2], min);
        return min;
    }

    private static void solve() {
        color[0][0] = house[0][0];
        color[0][1] = house[0][1];
        color[0][2] = house[0][2];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                color[i][j] = Math.min(color[i - 1][da[j]], color[i - 1][db[j]]) + house[i][j];
            }
        }
    }
}