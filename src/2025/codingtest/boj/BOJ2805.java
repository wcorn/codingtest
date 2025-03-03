package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2805"> 나무 자르기 </a>
 */
public class BOJ2805 {

    private static int N;
    private static int M;
    private static int[] arr;
    private static int max;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        max = 0;
        answer = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int height : arr) {
                if (height > mid) {
                    sum += height - mid;
                }
            }

            if (sum >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

}
