package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/16234"> 인구 이동 </a>
 */
public class BOJ16234 {

    private static int N;
    private static int L;
    private static int R;
    private static int[][] map;
    private static boolean[][] visited;
    private static boolean flag;
    private static int count;
    private static final int[] dx = new int[]{0, 0, -1, 1};
    private static final int[] dy = new int[]{-1, 1, 0, 0};
    private static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0;
        list = new ArrayList<>();
        do {
            flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        continue;
                    }
                    visited[i][j] = true;
                    find(i, j);
                    cal();
                    list.clear();
                }
            }
            if (flag) {
                count++;
            }
        } while (flag);
        System.out.println(count);
    }

    private static void find(int x, int y) {
        list.add(new int[]{x, y});
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            int dif = Math.abs(map[x][y] - map[nextX][nextY]);
            if (dif > R || dif < L) {
                continue;
            }
            flag = true;
            visited[nextX][nextY] = true;
            find(nextX, nextY);
        }
    }

    private static void cal() {
        if (list.isEmpty()) {
            return;
        }
        int sum = 0;
        for (int[] i : list) {
            sum += map[i[0]][i[1]];
        }
        sum /= list.size();
        for (int[] i : list) {
            map[i[0]][i[1]] = sum;
        }
    }
}
