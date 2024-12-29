package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ1697 {

    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        Set<Integer> s = new HashSet<>();
        int[] num;
        while (!q.isEmpty()) {
            num = q.poll();
            if (num[0] == K) {
                System.out.println(num[1]);
                break;
            }
            if (num[0] + 1 <= 100000 && !s.contains(num[0] + 1)) {
                q.add(new int[]{num[0] + 1, num[1] + 1});
                s.add(num[0] + 1);
            }
            if (num[0] - 1 >= 0 && !s.contains(num[0] - 1)) {
                q.add(new int[]{num[0] - 1, num[1] + 1});
                s.add(num[0] - 1);
            }
            if (num[0] * 2 <= 100000 && !s.contains(num[0] * 2)) {
                q.add(new int[]{num[0] * 2, num[1] + 1});
                s.add(num[0] * 2);
            }
        }
    }
}
