package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/14503"> 로봇 청소기 </a>
 */
public class BOJ14503 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    private static int rx;
    private static int ry;
    private static int rd;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        result = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        rx = Integer.parseInt(st.nextToken());
        ry = Integer.parseInt(st.nextToken());
        rd = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            // 1
            if (map[rx][ry] == 0) {
                result++;
                map[rx][ry] = -1;
            }
            // 3
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                rd = (rd + 3) % 4;
                int nextX = rx + dx[rd];
                int nextY = ry + dy[rd];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (map[nextX][nextY] != 0) {
                    continue;
                }
                rx = nextX;
                ry = nextY;
                flag = true;
                break;
            }
            if (flag) {
                continue;
            }
            // 2
            rx -= dx[rd];
            ry -= dy[rd];
            if (rx < 0 || ry < 0 || rx >= N || ry >= M || map[rx][ry] == 1) {
                break;
            }
        }
        System.out.println(result);
    }
}
