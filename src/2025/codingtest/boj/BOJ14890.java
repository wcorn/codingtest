package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/14890"> 경사로 </a>
 */
public class BOJ14890 {

    private static int N;
    private static int L;
    private static int[][] map1;
    private static int[][] map2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map1 = new int[N][N];
        map2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map1[i][j] = num;
                map2[j][i] = num;
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (check(map1[i])) {
                count++;
            }
            if (check(map2[i])) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean check(int[] arr) {
        boolean[] used = new boolean[N];
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) > 1) {
                return false;
            }
            if (arr[i] - arr[i + 1] == 1) {
                int t = arr[i + 1];
                if (i + L >= N) {
                    return false;
                }

                for (int j = 1; j <= L; j++) {
                    if (used[i + j]) {
                        return false;
                    }
                    used[i + j] = true;
                    if (arr[i + j] != t) {
                        return false;
                    }
                }
                i += L - 1;
            }
            if (arr[i] - arr[i + 1] == -1) {
                int t = arr[i];
                if (i+1 - L < 0) {
                    return false;
                }
                for (int j = 0; j < L; j++) {
                    if (used[i - j]) {
                        return false;
                    }
                    used[i - j] = true;
                    if (arr[i - j] != t) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
