package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/28279"> 덱 2 </a>
 */
public class BOJ28279 {

    private static int N;
    private static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Integer oper = Integer.parseInt(st.nextToken());
            switch (oper) {
                case 1: {
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                }
                case 2: {
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                }
                case 3: {
                    sb.append(dq.isEmpty() ? -1 : dq.removeFirst()).append("\n");
                    break;
                }
                case 4: {
                    sb.append(dq.isEmpty() ? -1 : dq.removeLast()).append("\n");
                    break;
                }
                case 5: {
                    sb.append(dq.size()).append("\n");
                    break;
                }
                case 6: {
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                }
                case 7: {
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
                    break;
                }
                case 8: {
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
