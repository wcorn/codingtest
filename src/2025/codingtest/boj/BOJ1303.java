package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1303"> 전쟁 - 전투 </a>
 */
public class BOJ1303 {

    private static int N;
    private static int M;
    private static char[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int blue = 0;
        int white = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                count = 0;
                if (map[i][j] == 'W') {
                    dfs(i, j, 'W');
                    white += count * count;
                }
                if (map[i][j] == 'B') {
                    dfs(i, j, 'B');
                    blue += count * count;
                }
            }
        }
        System.out.println(white + " " + blue);
    }

    private static void dfs(int x, int y, char c) {
        count++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                continue;
            }
            if (visited[nextX][nextY] || map[nextX][nextY] != c) {
                continue;
            }
            visited[nextX][nextY] = true;
            dfs(nextX, nextY, c);
        }
    }
}
