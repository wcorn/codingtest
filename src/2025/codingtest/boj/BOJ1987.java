package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1987"> 알파벳 </a>
 */
public class BOJ1987 {

    private static int R;
    private static int C;
    private static char[][] map;
    private static int top;
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[27];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        top = 0;
        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(top);
    }

    private static void dfs(int x, int y, int depth) {
        top = Math.max(top, depth);
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
                continue;
            }
            if (visited[map[nextX][nextY] - 'A']) {
                continue;
            }
            visited[map[nextX][nextY] - 'A'] = true;
            dfs(nextX, nextY, depth + 1);
            visited[map[nextX][nextY] - 'A'] = false;
        }
    }
}
