package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/2903"> 중앙 이동 알고리즘 </a>
 */
public class BOJ2903 {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int now = 2;
        for(int i = 0;i<N;i++){
            now+=now-1;
        }
        System.out.println(now*now);
    }
}
