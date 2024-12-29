package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ1987 {
    private static int R;
    private static int C;
    private static char[][] map;
    private static int result;
    private static boolean[] list;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        list = new boolean[26];
        result = 1;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        solve();
        System.out.println(result);
    }

    private static void solve() {
        dfs(0, 0, 0);
    }

    private static void dfs(int x, int y, int depth) {
        if (list[map[x][y] - 65]) {
            result = Math.max(depth, result);
            return;
        }
        int nextX;
        int nextY;
        list[map[x][y] - 65] = true;
        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C)
                continue;
            dfs(nextX, nextY, depth + 1);
        }
        list[map[x][y] - 65] = false;
    }
}