package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/13458"> 시험 감독 </a>
 */
public class BOJ13458 {

    private static int N;
    private static int[] A;
    private static int B;
    private static int C;
    private static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        result = N;
        for (int i = 0; i < N; i++) {
            A[i] -= B;
            if (A[i] > 0) {
                result += (A[i] + C - 1) / C;
            }
        }
        System.out.println(result);
    }
}
