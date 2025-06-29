package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/11286"> 절대값 힙</a>
 */
public class BOJ11286 {

    private static Queue<Integer> q;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        q = new PriorityQueue<>((n1, n2) -> Math.abs(n1) == Math.abs(n2) ?
            Integer.compare(n1, n2) : Integer.compare(Math.abs(n1), Math.abs(n2)));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (q.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            } else {
                q.add(x);
            }
        }
        System.out.println(sb);
    }
}