package codingtest.datastructure;

import java.io.*;
import java.util.*;

public class BOJ2346 {
    private static int N;
    private static Deque<balloon> deque;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        deque = new ArrayDeque<>();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            deque.add(new balloon(i + 1, Integer.parseInt(st.nextToken())));
        }
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        balloon now;
        balloon temp;
        do {
            now = deque.remove();
            sb.append(now.num).append(" ");
            if (now.paper < 0) {
                for (int i = 0; i < -now.paper; i++) {
                    temp = deque.removeLast();
                    deque.addFirst(temp);
                }
            } else {
                for (int i = 0; i < now.paper - 1; i++) {
                    temp = deque.remove();
                    deque.add(temp);
                }
            }
        } while (deque.size() != 1);
        sb.append(deque.peek().num);
    }

    private static class balloon {
        int num;
        int paper;

        public balloon(int num, int paper) {
            this.num = num;
            this.paper = paper;
        }
    }
}
