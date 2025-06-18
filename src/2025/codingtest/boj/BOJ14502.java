package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ14502 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static List<int[]> empty;
    private static List<int[]> virus;
    private static int result;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        empty = new ArrayList<>();
        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    empty.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        result = 0;
        for (int i = 0; i < empty.size() - 2; i++) {
            for (int j = i + 1; j < empty.size() - 1; j++) {
                for (int t = j + 1; t < empty.size(); t++) {
                    find(empty.get(i), empty.get(j), empty.get(t));
                }
            }
        }
        System.out.println(result);
    }

    private static void find(int[] p1, int[] p2, int[] p3) {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }
        temp[p1[0]][p1[1]] = 1;
        temp[p2[0]][p2[1]] = 1;
        temp[p3[0]][p3[1]] = 1;
        for (int[] v : virus) {
            dfs(v[0], v[1], temp);
        }
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    num++;
                }
            }
        }
        result = Math.max(result, num);
    }

    private static void dfs(int x, int y, int[][] temp) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }
            if (temp[nextX][nextY] != 0) {
                continue;
            }
            temp[nextX][nextY] = 2;
            dfs(nextX, nextY, temp);
        }
    }
}
