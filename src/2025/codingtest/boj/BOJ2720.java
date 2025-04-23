package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2720"> 세탁소 사장 동혁 </a>
 */
public class BOJ2720 {

    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());
            sb.append(C/25).append(" ");
            C%=25;
            sb.append(C/10).append(" ");
            C%=10;
            sb.append(C/5).append(" ");
            C%=5;
            sb.append(C).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
