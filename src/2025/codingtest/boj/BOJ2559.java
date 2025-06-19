package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2559"> 수열 </a>
 */
public class BOJ2559 {

    private static int N;
    private static int K;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        int result = sum;
        for (int i = K; i < N; i++) {
            sum += arr[i];
            sum -= arr[i - K];
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}
