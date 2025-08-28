package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 *  <a href="https://www.acmicpc.net/problem/10830"> 행렬 제곱 </a>
 */
public class BOJ10830 {

    private static int N;
    private static long B;
    private static int[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        origin = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] result;
        result = divide(origin, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] solve(int[][] arr1, int[][] arr2) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int t = 0; t < N; t++) {
                    temp[i][j] += arr1[i][t] * arr2[t][j];
                    temp[i][j] %= 1000;
                }
            }
        }
        return temp;
    }

    private static int[][] divide(int[][] arr, long depth) {
        if (depth == 1) {
            return arr;
        }
        int[][] div = divide(arr, depth / 2);
        div = solve(div, div);
        if (depth % 2 == 1) {
            div = solve(div, origin);
        }
        return div;
    }
}
