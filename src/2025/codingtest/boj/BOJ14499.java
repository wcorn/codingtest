package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/14499"> 주사위 굴리기 </a>
 */
public class BOJ14499 {

    private static int N;
    private static int M;
    private static int K;
    private static Dice dice;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dice = new Dice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dice.init();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!dice.possible(num)) {
                continue;
            }
            sb.append(dice.move(num)).append("\n");
        }
        System.out.println(sb);
    }

    private static class Dice {

        private static final int dx[] = {0, 0, -1, 1};
        private static final int dy[] = {1, -1, 0, 0};

        int left;
        int right;
        int top;
        int bottom;
        int front;
        int back;
        int x;
        int y;

        public Dice(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void init() {
            back = map[x][y];
            map[x][y] = 0;
        }

        public int move(int num) {
            x += dx[num - 1];
            y += dy[num - 1];
            switch (num) {
                case 1:
                    east();
                    break;
                case 2:
                    west();
                    break;
                case 3:
                    north();
                    break;
                case 4:
                    south();
                    break;
            }
            if (map[x][y] == 0) {
                map[x][y] = back;
            } else {
                back = map[x][y];
                map[x][y] = 0;
            }
            return front;
        }

        private void south() {
            int tmp = back;
            back = top;
            top = front;
            front = bottom;
            bottom = tmp;
        }

        private void north() {
            int tmp = back;
            back = bottom;
            bottom = front;
            front = top;
            top = tmp;
        }

        private void east() {
            int tmp = back;
            back = right;
            right = front;
            front = left;
            left = tmp;
        }

        private void west() {
            int tmp = back;
            back = left;
            left = front;
            front = right;
            right = tmp;
        }

        public boolean possible(int num) {
            int nextX = x + dx[num - 1];
            int nextY = y + dy[num - 1];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                return false;
            }
            return true;
        }
    }
}