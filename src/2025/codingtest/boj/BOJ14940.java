package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/14940"> 쉬운 최단거리 </a>
 */
public class BOJ14940 {

    private static int[][] map;
    private static int n;
    private static int m;
    private static int[][] result;
    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(result[i], -1);
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        result[x][y] = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = temp[0] + dx[i];
                int nextY = temp[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
                if (map[nextX][nextY] == 0 || result[nextX][nextY] != -1) {
                    continue;
                }
                result[nextX][nextY] = temp[2] + 1;
                q.add(new int[]{nextX, nextY, result[nextX][nextY]});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && result[i][j] == -1) {
                    result[i][j] = 0;
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
