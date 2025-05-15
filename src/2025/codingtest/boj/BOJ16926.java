package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/16926"> 배열 돌리기 1 </a>
 */
public class BOJ16926 {

    private static int N;
    private static int M;
    private static int R;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < R; i++) {
            active();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void active() {
        int min = Math.min(N, M) / 2;
        System.out.println(min);
        for (int i = 0; i < min; i++) {
            int minX = 0 + i;
            int minY = 0 + i;
            int maxX = N - 1 - i;
            int maxY = M - 1 - i;
            circle(minX, minY, maxX, maxY);
        }
    }

    private static void circle(int minX, int minY, int maxX, int maxY) {
        int temp = map[minX][minY];
        for (int i = minY; i < maxY; i++) {
            map[minX][i] = map[minX][i + 1];
        }
        for (int i = minX; i < maxX; i++) {
            map[i][maxY] = map[i + 1][maxY];
        }
        for (int i = maxY; i > minY; i--) {
            map[maxX][i] = map[maxX][i - 1];
        }
        for (int i = maxX; i > minX; i--) {
            map[i][minY] = map[i - 1][minY];
        }
        map[minX + 1][minY] = temp;
    }
}
