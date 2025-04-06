package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/17070"> 파이프 옮기기 1 </a>
 */
public class BOJ17070 {

    private static int N;
    private static int[][] map;
    private static final int[] dx = new int[]{0, 1, 1};
    private static final int[] dy = new int[]{1, 0, 1};
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        find(0, 1, 0);
        System.out.println(result);
    }

    private static void find(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1) {
            result++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue;
            }
            if (dir == 0 && i == 1 || dir == 1 && i == 0) {
                continue;
            }
            if (map[nextX][nextY] == 1) {
                continue;
            }
            if (i == 2 && (map[x + dx[0]][y + dy[0]] == 1 || map[x + dx[1]][y + dy[1]] == 1)) {
                continue;
            }
            find(nextX, nextY, i);
        }
    }
}
