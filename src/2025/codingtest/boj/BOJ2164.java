package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2164"> 카드 2 </a>
 */
public class BOJ2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.addFirst(i);
        }
        while (dq.size() != 1) {
            dq.removeLast();
            dq.addFirst(dq.removeLast());
        }
        System.out.println(dq.remove());
    }
}
