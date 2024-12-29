package codingtest.greedy;

import java.util.*;
import java.io.*;

public class BOJ1339 {
    private static int N;
    private static List<Integer> list;
    private static PriorityQueue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        q = new PriorityQueue<>(Collections.reverseOrder());
        N = Integer.parseInt(br.readLine());
        String str;
        char[] ch;
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            list.add(0);
        }
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            ch = str.toCharArray();
            for (int j = 0; j < ch.length; j++) {
                list.set(ch[j] - 65, (int) (list.get(ch[j] - 65) + Math.pow(10, ch.length - j - 1)));
            }
        }
        for (int i = 0; i < 26; i++) {
            if (list.get(i) != 0)
                q.add(list.get(i));
        }
        for (int i = 9; !q.isEmpty(); i--) {
            answer += q.remove() * i;
        }
        System.out.println(answer);
    }
}
