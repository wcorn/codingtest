package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2460"> 지능형 기차 2 </a>
 */
public class BOJ2460 {

    private static int N;
    private static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = 0;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            N-=Integer.parseInt(st.nextToken());
            N+=Integer.parseInt(st.nextToken());
            max = Math.max(max,N);
        }
        System.out.println(max);
    }
}
