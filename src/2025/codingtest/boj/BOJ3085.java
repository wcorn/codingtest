package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/3085"> 사탕 게임</a>
 */
public class BOJ3085 {

    private static int N;
    private static char[][] map;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = 0;
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(j, i, j + 1, i);
                calc();
                swap(j, i, j + 1, i);
                swap(i, j, i, j + 1);
                calc();
                swap(i, j, i, j + 1);
            }
        }
        System.out.println(max);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    private static void calc() {
        for (int i = 0; i < N; i++) {
            int count1 = 1;
            int count2 = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    count1++;
                } else {
                    count1 = 1;
                }
                if (map[j][i] == map[j + 1][i]) {
                    count2++;
                } else {
                    count2 = 1;
                }
                max = Math.max(count1, max);
                max = Math.max(count2, max);
            }
        }
    }
}
