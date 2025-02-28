package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/17144"> 미세먼지 안녕! </a>
 */
public class BOJ17144 {

    private static int R;
    private static int C;
    private static int T;
    private static int[][] map;
    private static int[][] temp;
    private static int r1;
    private static int r2;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < R; i++) {
            if (map[i][0] == -1) {
                r1 = i;
                r2 = i + 1;
                break;
            }
        }
        for (int i = 0; i < T; i++) {
            recursion();
        }
        System.out.println(result());
    }

    private static void recursion() {
        temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                diffusion(i, j);
            }
        }
        clear();
        put();
    }

    private static void diffusion(int x, int y) {
        int count = 0;
        int dust = map[x][y] / 5;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
                continue;
            }
            if (map[nextX][nextY] == -1) {
                continue;
            }
            temp[nextX][nextY] += dust;
            count++;
        }
        temp[x][y] += (map[x][y] - count * dust);
    }

    private static void clear() {
        for (int i = r1 - 1; i > 0; i--) {
            temp[i][0] = temp[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            temp[0][i] = temp[0][i + 1];
        }
        for (int i = 0; i < r1; i++) {
            temp[i][C - 1] = temp[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            temp[r1][i] = temp[r1][i - 1];
        }
        temp[r1][1] = 0;
        for (int i = r2 + 1; i < R - 1; i++) {
            temp[i][0] = temp[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            temp[R - 1][i] = temp[R - 1][i + 1];
        }
        for (int i = R - 1; i > r2; i--) {
            temp[i][C - 1] = temp[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            temp[r2][i] = temp[r2][i - 1];
        }
        temp[r2][1] = 0;
    }

    private static void put() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[i][j];
            }
        }
        map[r1][0] = -1;
        map[r2][0] = -1;
    }

    private static int result() {
        int num = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                num += map[i][j];
            }
        }
        return num;
    }
}
