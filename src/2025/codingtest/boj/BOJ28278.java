package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/28278"> 스택 2 </a>
 */
public class BOJ28278 {

    private static int N;
    private static Stack<Integer> s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        s = new Stack<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            switch (oper) {
                case 1: {
                    s.add(Integer.parseInt(st.nextToken()));
                    break;
                }
                case 2: {
                    if (s.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(s.pop()).append("\n");
                    }
                    break;
                }
                case 3: {
                    sb.append(s.size()).append("\n");

                    break;
                }
                case 4: {
                    sb.append(s.isEmpty() ? 1 : 0).append("\n");
                    break;
                }
                case 5: {
                    sb.append(s.isEmpty() ? -1 : s.peek()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
