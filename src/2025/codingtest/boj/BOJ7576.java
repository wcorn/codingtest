package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/7576"> 토마토 </a>
 */
public class BOJ7576 {

    private static int M;
    private static int N;
    private static int[][] map;
    private static Queue<int[]> q;
    private static int result;
    private static final int[] dx = new int[]{0, 0, -1, 1};
    private static final int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        result = 0;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        find();
        if (!check()) {
            result = -1;
        }
        System.out.println(result);
    }

    private static void find() {
        int size = q.size();
        while (!q.isEmpty()) {
            if (size == 0) {
                result++;
                size = q.size();
            }
            int[] t = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = t[0] + dx[i];
                int nextY = t[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (map[nextX][nextY] == 1 || map[nextX][nextY] == -1) {
                    continue;
                }
                map[nextX][nextY] = 1;
                q.add(new int[]{nextX, nextY});
            }
            size--;
        }
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
}
