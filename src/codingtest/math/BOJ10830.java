package codingtest.math;

import java.io.*;
import java.util.*;

public class BOJ10830 {
    private static int N;
    private static long B;
    private static int[][] A;
    private static Map<Long, int[][]> map;
    private static final int MOD = 1000;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        map = new HashMap<>();
        sb = new StringBuilder();
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        map.put(1L, A);
        int[][] result = recursion(B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static int[][] recursion(long index) {
        if (map.containsKey(index)) return map.get(index);
        int[][] temp = recursion(index/2L);
        temp = calculate(temp,temp);
        if (index % 2L == 1L) {
            temp = calculate(temp,A);
        }
        map.put(index,temp);
        return temp;
    }

    private static int[][] calculate(int[][] a, int[][] b) {
        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += a[i][k] * b[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}