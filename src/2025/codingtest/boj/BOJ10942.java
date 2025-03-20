package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/10942"> 팰린드롬? </a>
 */
public class BOJ10942 {

    private static int N;
    private static int M;
    private static int[] arr;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            map[i][i] = true;
            for (int j = 1; j <= i && j < N - i; j++) {
                if (arr[i - j] != arr[i + j]) {
                    flag = false;
                }
                if (flag) {
                    map[i - j][i + j] = true;
                }
            }
            flag = true;
            for (int j = 0; j <= i && j < N - i - 1; j++) {
                if (arr[i - j] != arr[i + 1 + j]) {
                    flag = false;
                }
                if (flag) {
                    map[i - j][i + 1 + j] = true;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (map[a][b]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
