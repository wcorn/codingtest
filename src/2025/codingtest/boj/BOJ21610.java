package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/21610"> 마법사 상어와 비바라기 </a>
 */
public class BOJ21610 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static Queue<int[]> q;
    private static final int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.add(new int[]{N - 1, 0});
        q.add(new int[]{N - 1, 1});
        q.add(new int[]{N - 2, 0});
        q.add(new int[]{N - 2, 1});
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            visited = new boolean[N][N];
            move(d, s);
            rain();
            magic();
            cloud();
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result);
    }

    private static void move(int d, int s) {
        Queue<int[]> temp = new LinkedList<>();
        while (!q.isEmpty()) {
            int[] t = q.poll();
            temp.add(new int[]{(t[0] + (dx[d] + N) * s) % N, (t[1] + (dy[d] + N) * s) % N});
        }
        q = temp;
    }

    private static void rain() {
        Queue<int[]> temp = new LinkedList<>();
        while (!q.isEmpty()) {
            int[] t = q.poll();
            map[t[0]][t[1]]++;
            visited[t[0]][t[1]] = true;
            temp.add(t);
        }
        q = temp;
    }

    private static void magic() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int num = 0;
            for (int j = 0; j < 4; j++) {
                int nextX = t[0] + dx[j * 2 + 1];
                int nextY = t[1] + dy[j * 2 + 1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }
                if (map[nextX][nextY] > 0) {
                    num++;
                }
            }
            map[t[0]][t[1]] += num;
        }
    }

    private static void cloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2 && !visited[i][j]) {
                    q.add(new int[]{i, j});
                    map[i][j] -= 2;
                }
            }
        }
    }
}
