package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/18258"> 큐 2 </a>
 */
public class BOJ18258 {

    private static int N;
    private static Deque<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            switch (oper) {
                case "push": {
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop": {
                    sb.append(q.isEmpty() ? -1 : q.pollLast()).append("\n");
                    break;
                }
                case "size": {
                    sb.append(q.size()).append("\n");
                    break;
                }
                case "empty": {
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                }
                case "front": {
                    sb.append(q.isEmpty()?-1:q.peekLast()).append("\n");
                    break;
                }
                case "back": {
                    sb.append(q.isEmpty()?-1:q.peekFirst()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
