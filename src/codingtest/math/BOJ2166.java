package codingtest.math;

import java.io.*;
import java.util.*;

public class BOJ2166 {
    private static int N;
    private static long[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }
        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];
        System.out.println(solve());
    }

    private static String solve() {
        long a = 0;
        long b = 0;
        for (int i = 0; i < N; i++) {
            a += arr[i][0] * arr[i + 1][1];
            b += arr[i][1] * arr[i + 1][0];
        }
        return String.format("%.1f", (Math.abs(a - b) / 2.0));
    }
}
