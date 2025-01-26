package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1806"> 부분합 </a>
 */
public class BOJ1806 {

    private static int N;
    private static int S;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int back = 0;
        int front = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        for (; back < N; back++) {
            sum += arr[back];
            while (sum >= S) {
                answer = Math.min(answer, back - front + 1);
                sum -= arr[front++];
            }
        }
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        System.out.println(answer);
    }
}
