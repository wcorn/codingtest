package codingtest.simulation;

import java.util.*;
import java.io.*;

public class BOJ17144 {
    private static int R;
    private static int C;
    private static int T;
    private static int[][] A;
    private static int[][] DUST;
    private static int upX;
    private static int downX;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        A = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == -1 && upX == 0) {
                    upX = i;
                    downX = i + 1;
                }
            }
        }

        System.out.println(solve());
    }

    public static int solve() {
        for (int i = 0; i < T; i++) {
            DUST = new int[R][C];
            dustDiffusion();
            airCleanerWork();
        }
        return calculate();
    }

    private static int calculate() {
        int answer = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += A[i][j];
            }
        }
        return answer;
    }

    private static void airCleanerWork() {
        for (int x = upX - 1; x > 0; x--) {
            A[x][0] = A[x - 1][0];
        }
        for (int y = 0; y < C - 1; y++) {
            A[0][y] = A[0][y + 1];
        }
        for (int x = 0; x < upX; x++) {
            A[x][C - 1] = A[x + 1][C - 1];
        }
        for (int y = C - 1; y > 1; y--) {
            A[upX][y] = A[upX][y - 1];
        }
        A[upX][1] = 0;
        for (int x = downX + 1; x < R - 1; x++) {
            A[x][0] = A[x + 1][0];
        }
        for (int y = 0; y < C - 1; y++) {
            A[R - 1][y] = A[R - 1][y + 1];
        }
        for (int x = R - 1; x > downX; x--) {
            A[x][C - 1] = A[x - 1][C - 1];
        }
        for (int y = C - 1; y > 1; y--) {
            A[downX][y] = A[downX][y - 1];
        }
        A[downX][1] = 0;
    }

    private static void dustDiffusion() {
        int temp;
        int nextX;
        int nextY;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp = A[i][j] / 5;
                for (int k = 0; k < 4; k++) {
                    nextX = i + dx[k];
                    nextY = j + dy[k];
                    if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C)
                        continue;
                    if (A[nextX][nextY] == -1)
                        continue;
                    DUST[nextX][nextY] += temp;
                    A[i][j] -= temp;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] += DUST[i][j];
            }
        }
    }
}
