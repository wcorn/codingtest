package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/12851"> 숨바꼭질 2 </a>
 */
public class BOJ12851 {

    private static int N;
    private static int K;
    private static int[] time;
    private static final int INF = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }
        time = new int[INF + 1];
        Arrays.fill(time, -1);
        time[N] = 0;
        int count = 0;
        int minTime = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while (!q.isEmpty()) {
            int now = q.poll();
            int t = time[now];

            if (minTime < t) {
                continue;
            }

            int[] nexts = {now - 1, now + 1, now * 2};
            for (int next : nexts) {
                if (next < 0 || next > INF) {
                    continue;
                }

                if (time[next] == -1 || time[next] == t + 1) {
                    time[next] = t + 1;

                    if (next == K) {
                        if (minTime == Integer.MAX_VALUE) {
                            minTime = time[next];
                        }
                        if (time[next] == minTime) {
                            count++;
                        }
                    } else {
                        q.add(next);
                    }
                }
            }
        }

        System.out.println(time[K]);
        System.out.println(count);
    }
}