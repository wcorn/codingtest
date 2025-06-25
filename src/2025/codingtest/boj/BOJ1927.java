package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1927"> 최소 힙</a>
 */
public class BOJ1927 {

    private static int N;
    private static int B;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0 && pq.isEmpty()) {
                sb.append("0").append("\n");
            } else if (num == 0) {
                sb.append(pq.poll()).append("\n");
            } else {
                pq.add(num);
            }
        }
        System.out.println(sb);
    }
}
