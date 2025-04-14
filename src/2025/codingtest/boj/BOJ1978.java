package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1978"> 소수 찾기</a>
 */
public class BOJ1978 {

    private static int N;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        answer = 0;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (check(Integer.parseInt(st.nextToken()))) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean check(int num) {
        if (num == 1) {
            return false;
        }
        int size = (int) Math.sqrt(num);
        for (int i = 2; i <= size; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
