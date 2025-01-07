package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/16953"> A → B </a>
 */
public class BOJ16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(solve(B, A));
    }

    private static int solve(int start, int end) {
        Set<Integer> s = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 1});
        while (!q.isEmpty()) {
            int[] c = q.poll();
            if (c[0] == end) {
                return c[1];
            }
            if (c[0] % 2 == 0 && !s.contains(c[0] / 2)) {
                q.add(new int[]{c[0] / 2, c[1] + 1});
                s.add(c[0] / 2);
            }
            if (c[0] % 10 == 1 && !s.contains(c[0] / 10)) {
                q.add(new int[]{c[0] / 10, c[1] + 1});
                s.add(c[0] / 10);
            }
        }
        return -1;
    }
}
