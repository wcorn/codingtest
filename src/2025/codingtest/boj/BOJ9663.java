package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/9663"> N-Queen </a>
 */
public class BOJ9663 {

    private static int N;
    private static int[] arr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = 0;
        recursion(0);
        System.out.println(answer);
    }

    private static void recursion(int depth) {
        if (depth == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (judge(depth)) {
                recursion(depth + 1);
            }
        }
    }

    private static boolean judge(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth] || Math.abs(arr[i] - arr[depth]) == Math.abs(i - depth)) {
                return false;
            }
        }
        return true;
    }
}
