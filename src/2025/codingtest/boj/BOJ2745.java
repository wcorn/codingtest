package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2745"> 진법 변환 </a>
 */
public class BOJ2745 {

    private static char[] N;
    private static int B;
    private static Long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken().toCharArray();
        B = Integer.parseInt(st.nextToken());
        answer = 0L;
        for (int i = 0; i < N.length; i++) {
            long num = Character.isDigit(N[i]) ? N[i] - '0' : N[i] - 'A'+10;
            answer += (long)(Math.pow(B,N.length - i - 1) * num);
        }
        System.out.println(answer);
    }
}
