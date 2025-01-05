package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ12865 {

    private static int N;
    private static int K;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            for(int w = K-W; w >= 0; w--){
                dp[w+W] = Math.max(dp[w+W],dp[w]+V);
            }
        }
        System.out.println(dp[K]);
    }
}
