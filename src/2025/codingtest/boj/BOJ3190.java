package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/3190"> 뱀</a>
 */
public class BOJ3190 {

    private static int N;
    private static int K;
    private static int L;
    private static int[][] map;
    // 우 위 왼 아
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static Queue<int[]> snake;
    private static int x;
    private static int y;
    private static int dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
        }
        L = Integer.parseInt(br.readLine());
        Queue<SMI> q = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            q.add(new SMI(X, C));
        }
        int time = 0;
        x = 0;
        y = 0;
        dir = 0;
        snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        map[x][y] = 1;
        while (true) {
            time++;
            if (!move()) {
                break;
            }
            if (!q.isEmpty() && q.peek().x == time) {
                SMI smi = q.poll();
                if (smi.c == 'L') {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                } else if (smi.c == 'D') {
                    dir--;
                    if (dir == -1) {
                        dir = 3;
                    }
                }
            }
        }
        System.out.println(time);
    }

    private static boolean move() {
        x += dx[dir];
        y += dy[dir];
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }
        if (map[x][y] == 1) {
            return false;
        }
        if (map[x][y] != 2) {
            int[] temp = snake.poll();
            map[temp[0]][temp[1]] = 0;
        }
        map[x][y] = 1;
        snake.add(new int[]{x, y});
        return true;
    }

    private static class SMI {

        int x;
        char c;

        SMI(int x, char c) {
            this.x = x;
            this.c = c;
        }
    }
}
