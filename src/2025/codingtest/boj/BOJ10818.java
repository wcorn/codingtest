package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/10818"> 최소, 최대 </a>
 */
public class BOJ10818 {

    private static int N;
    private static int max;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        System.out.println(min + " " + max);
    }
}
