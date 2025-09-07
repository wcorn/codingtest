package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/15683"> 감시 </a>
 */
public class BOJ15683 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final int[][][] dd = {{}, {{0}, {1}, {2}, {3}}, {{1, 3}, {0, 2}},
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
        {{0, 1, 2, 3}}};
    private static List<int[]> list;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num >= 1 && num <= 5) {
                    list.add(new int[]{i, j});
                }
            }
        }
        result = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int depth) {
        if (depth == list.size()) {
            check();
            return;
        }
        int x = list.get(depth)[0];
        int y = list.get(depth)[1];
        for (int[] t : dd[map[x][y]]) {
            int nextX;
            int nextY;
            for (int i : t) {
                nextX = x;
                nextY = y;
                while (true) {
                    nextX += dx[i];
                    nextY += dy[i];
                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                        break;
                    }
                    if (map[nextX][nextY] == 6) {
                        break;
                    }
                    if (map[nextX][nextY] > 0) {
                        continue;
                    }
                    map[nextX][nextY] -= 1;
                }
            }
            dfs(depth + 1);

            for (int i : t) {
                nextX = x;
                nextY = y;
                while (true) {
                    nextX += dx[i];
                    nextY += dy[i];
                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                        break;
                    }
                    if (map[nextX][nextY] == 6) {
                        break;
                    }
                    if (map[nextX][nextY] > 0) {
                        continue;
                    }
                    map[nextX][nextY] += 1;

                }
            }
        }
    }

    private static void check() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.min(count, result);
    }
}
