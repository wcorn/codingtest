package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ2638 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int M;
    private static int result;
    private static int[][] count;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        System.out.println(result);
    }

    private static void solve() {
        result = 0;
        while (true) {
            count = new int[N][M];
            visited = new boolean[N][M];
            dfs(0, 0);
            result++;
            clean();
            if (isEmptyMap())
                return;
        }
    }

    private static void clean() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && count[i][j] >= 2)
                    map[i][j] = 0;
            }
        }
    }

    private static boolean isEmptyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int nextX;
        int nextY;
        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                continue;
            count[nextX][nextY]++;
            if (visited[nextX][nextY] || map[nextX][nextY] == 1)
                continue;
            dfs(nextX, nextY);
        }
    }
}
