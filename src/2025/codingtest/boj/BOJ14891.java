package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/14891"> 톱니바퀴 </a>
 */
public class BOJ14891 {

    private static int[][] arr;
    private static boolean[] visited;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        arr = new int[4][8];
        for (int i = 0; i < 4; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            visited = new boolean[4];
            spin(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            Arrays.fill(visited, false);
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                result += (int) Math.pow(2, i);
            }
        }
        System.out.println(result);
    }

    private static void spin(int number, int dir) {
        if (visited[number] || dir == 0) {
            return;
        }
        visited[number] = true;
        if (number > 0) {
            int t = dir * -1;
            if (arr[number][6] == arr[number - 1][2]) {
                t = 0;
            }
            spin(number - 1, t);
        }
        if (number < 3) {
            int t = dir * -1;
            if (arr[number][2] == arr[number + 1][6]) {
                t = 0;
            }
            spin(number + 1, t);
        }
        if (dir == -1) {
            int t = arr[number][0];
            for (int i = 0; i < 7; i++) {
                arr[number][i] = arr[number][i + 1];
            }
            arr[number][7] = t;
        } else if (dir == 1) {
            int t = arr[number][7];
            for (int i = 7; i > 0; i--) {
                arr[number][i] = arr[number][i - 1];
            }
            arr[number][0] = t;
        }
    }
}
