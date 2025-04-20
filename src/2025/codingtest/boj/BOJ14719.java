package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/14719"> 빗물 </a>
 */
public class BOJ14719 {

    private static int H;
    private static int W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        int[] arr1 = new int[W];
        int[] arr2 = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < W; i++) {
            arr1[i] = max;
            max = Math.max(max, arr[i]);
        }
        max = 0;
        for (int i = W - 1; i >= 0; i--) {
            arr2[i] = max;
            max = Math.max(max, arr[i]);
        }
        int answer = 0;
        for (int i = 1; i < W - 1; i++) {
            int num = Math.min(arr1[i], arr2[i]) - arr[i];
            if (num <= 0) {
                continue;
            }
            answer += num;
        }
        System.out.println(answer);
    }
}
