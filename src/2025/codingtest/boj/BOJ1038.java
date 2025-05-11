package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1038"> 감소하는 수 </a>
 */
public class BOJ1038 {

    private static int N;
    private static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            recursion(i, 0);
        }
        Collections.sort(list);
        if (N > 1022) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }

    private static void recursion(long num, int depth) {
        if (depth == 10) {
            return;
        }
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            recursion(num * 10 + i, depth + 1);
        }
    }
}
