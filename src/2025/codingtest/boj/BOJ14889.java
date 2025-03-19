package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/14889"> 스타트와 링크 </a>
 */
public class BOJ14889 {

    private static int N;
    private static int[][] map;
    private static int result;
    private static boolean[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new boolean[N];
        result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find(0, 0);
        System.out.println(result);
    }

    private static void find(int depth, int num) {
        if (depth == N / 2) {
            int n = calculate();
            result = Math.min(result, n);
            return;
        }
        if (depth > N / 2) {
            return;
        }
        for (int i = num; i < N; i++) {
            dist[i] = true;
            find(depth + 1, i + 1);
            dist[i] = false;
        }
    }

    private static int calculate() {
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (dist[i] && dist[j]) {
                    num += map[i][j];
                    num += map[j][i];
                }
                if (!dist[i] && !dist[j]) {
                    num -= map[i][j];
                    num -= map[j][i];
                }
            }
        }
        return Math.abs(num);
    }
}
