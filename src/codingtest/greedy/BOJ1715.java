package codingtest.greedy;

import java.io.*;
import java.util.*;

public class BOJ1715 {
    private static int N;
    private static PriorityQueue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
        int ans = 0;
        while (q.size() > 1) {
            int k = q.remove() + q.remove();
            ans += k;
            q.add(k);
        }
        System.out.println(ans);
    }
}
