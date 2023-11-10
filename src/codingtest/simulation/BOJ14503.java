package codingtest.simulation;

import java.io.*;
import java.util.*;

public class BOJ14503 {
    static int N;
    static int M;
    static int[][] map;
    static Robot robot;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        System.out.println(result);
    }

    private static void solve() {
        while (true) {
            robot.clear();
            if (robot.check()) {
                if (robot.backCheck()) {
                    robot.backMove();
                } else {
                    return;
                }
            } else {
                robot.execution();
            }
        }
    }

    private static class Robot {
        int r, c;
        int d;

        public Robot(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        public void clear() {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                result++;
            }
        }

        public boolean check() {
            for (int i = 0; i < 4; i++) {
                if (map[r + dx[i]][c + dy[i]] == 0)
                    return false;
            }
            return true;
        }

        public boolean backCheck() {
            int back = (d + 2) % 4;
            return map[r + dx[back]][c + dy[back]] != 1;
        }

        public void backMove() {
            int back = (d + 2) % 4;
            r = r + dx[back];
            c = c + dy[back];
        }

        public void execution() {
            d -= 1;
            if(d == -1) d = 3;
            if (map[r + dx[d]][c + dy[d]] == 0) {
                r = r + dx[d];
                c = c + dy[d];
            }
        }
    }
}
