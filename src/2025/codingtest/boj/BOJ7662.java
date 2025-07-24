package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/7662"> 이중 우선순위 큐 </a>
 */
public class BOJ7662 {

    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            Queue<Integer> minq = new PriorityQueue<>();
            Queue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (oper.equals("I")) {
                    minq.add(num);
                    maxq.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (!map.isEmpty()) {
                    if (num == 1) {
                        delete(maxq, map);
                    } else {
                        delete(minq, map);
                    }

                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                int max = delete(maxq, map);
                int min = map.isEmpty() ? max : delete(minq, map);
                sb.append(max).append(" ").append(min).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int delete(Queue<Integer> q, Map<Integer, Integer> map) {
        int res = 0;
        while (!q.isEmpty()) {
            res = q.poll();
            int num = map.getOrDefault(res, 0);
            if (num == 0) {
                continue;
            }
            if (num == 1) {
                map.remove(res);
            } else {
                map.put(res, num - 1);
            }
            break;
        }
        return res;
    }

}
