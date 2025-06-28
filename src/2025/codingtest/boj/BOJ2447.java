package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2447"> 별 찍기 - 10 </a>
 */
public class BOJ2447 {

    private static int N;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        recursion(N, 0, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursion(int size, int x, int y) {
        if (size == 3) {
            map[x][y] = true;
            map[x + 1][y] = true;
            map[x + 2][y] = true;
            map[x][y + 1] = true;
            map[x][y + 2] = true;
            map[x + 1][y + 2] = true;
            map[x + 2][y + 1] = true;
            map[x + 2][y + 2] = true;
            return;
        }
        int s = size / 3;
        recursion(s, x, y);
        recursion(s, x + s, y);
        recursion(s, x + 2 * s, y);
        recursion(s, x, y + s);
        recursion(s, x, y + 2 * s);
        recursion(s, x + s, y + 2 * s);
        recursion(s, x + 2 * s, y + s);
        recursion(s, x + 2 * s, y + 2 * s);
    }
}
