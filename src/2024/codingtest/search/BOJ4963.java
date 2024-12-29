package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ4963 {
    private static StringBuilder sb;
    private static int w, h;
    private static int[][] map;
    private static boolean[][] visited;
    private static int result;
    private static final int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    private static final int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 || h == 0)
                break;
            map = new int[h][w];
            visited = new boolean[h][w];
            result = 0;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve();
        }

        System.out.println(sb);
    }

    private static void solve() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    result++;
                }
            }
        }
        sb.append(result).append("\n");
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int nextX;
        int nextY;
        for (int i = 0; i < 8; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];
            if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w)
                continue;
            if (visited[nextX][nextY])
                continue;
            if (map[nextX][nextY] != 1)
                continue;
            dfs(nextX, nextY);
        }
    }
}
