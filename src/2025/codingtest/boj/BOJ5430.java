package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/5430"> AC </a>
 */
public class BOJ5430 {

    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] ch = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            Deque<Integer> dq = new LinkedList<>();
            if (n > 0) {
                String[] tokens = arrStr.substring(1, arrStr.length() - 1).split(",");
                for (String token : tokens) {
                    dq.addLast(Integer.parseInt(token));
                }
            }
            boolean tag = false;
            boolean flag = true;

            for (char c : ch) {
                if (c == 'D') {
                    if (dq.isEmpty()) {
                        tag = true;
                        break;
                    }
                    if (flag) {
                        dq.removeFirst();
                    } else {
                        dq.removeLast();
                    }
                } else if (c == 'R') {
                    flag = !flag;
                }
            }
            if (tag) {
                sb.append("error").append("\n");
                continue;
            }
            sb.append("[");
            while(!dq.isEmpty()) {
                if (flag) {
                    sb.append(dq.removeFirst());
                } else {
                    sb.append(dq.removeLast());
                }
                if(!dq.isEmpty())
                    sb.append(",");
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }
}
