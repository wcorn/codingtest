package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/11559"> Puyo Puyo </a>
 */
public class BOJ11559 {

    private static char[][] map;
    private static Set<int[]> s;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        s = new HashSet<>();
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int count = 0;
        while (boom()) {
            count++;
            down();
        }
        System.out.println(count);
    }

    private static boolean boom() {
        boolean flag = false;
        visited = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (visited[i][j] || map[i][j] == '.') {
                    continue;
                }
                visited[i][j] = true;
                s.add(new int[]{i, j});
                dfs(i, j, map[i][j]);
                if (s.size() >= 4) {
                    remove();
                    flag = true;
                }
                s.clear();
            }
        }
        return flag;
    }

    private static void dfs(int x, int y, char c) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= 12 || nextY >= 6) {
                continue;
            }
            if (visited[nextX][nextY] || map[nextX][nextY] != c) {
                continue;
            }
            visited[nextX][nextY] = true;
            s.add(new int[]{nextX, nextY});
            dfs(nextX, nextY, c);
        }
    }

    private static void remove() {
        for (int[] i : s) {
            map[i[0]][i[1]] = '.';
        }
    }

    private static void down() {
        for (int i = 5; i >= 0; i--) {
            for (int j = 11; j >= 0; j--) {
                if (map[j][i] != '.') {
                    continue;
                }
                for (int t = j - 1; t >= 0; t--) {
                    if (map[t][i] != '.') {
                        map[j][i] = map[t][i];
                        map[t][i] = '.';
                        break;
                    }
                }
            }
        }
    }
}
