package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/2023"> 신기한 소수 </a>
 */
public class BOJ2023 {

    private static int N;
    private static int[] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        find(0);
        System.out.println(sb);
    }

    private static void find(int depth) {
        if (depth == N) {
            for (int i : arr) {
                sb.append(i);
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            arr[depth] = i;
            if (check(depth)) {
                continue;
            }
            find(depth + 1);
        }
    }

    private static boolean check(int depth) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= depth; i++) {
            s.append(arr[i]);
        }
        int num = Integer.parseInt(s.toString());
        int size = (int) Math.sqrt(num);
        if(num==1)
            return true;
        for (int i = 2; i <= size; i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }
}
