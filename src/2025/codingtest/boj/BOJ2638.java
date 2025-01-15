package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2638"> 치즈 </a>
 */
public class BOJ2638 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static int answer;
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static int[][] house;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        while (true) {
            house = new int[N+2][M+2];
            visited = new boolean[N+2][M+2];
            dfs(0, 0);
            melt();
            answer++;
            if (check()) {
                break;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N+2 || nextY >= M+2) {
                continue;
            }
            if (map[nextX][nextY] == 1) {
                house[nextX][nextY]++;
            }
            if (visited[nextX][nextY] || map[nextX][nextY] == 1) {
                continue;
            }
            visited[nextX][nextY] = true;
            dfs(nextX, nextY);
        }
    }

    private static void melt() {
        for (int i = 0; i < N+2; i++) {
            for (int j = 0; j < M+2; j++) {
                if (house[i][j] >= 2) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
