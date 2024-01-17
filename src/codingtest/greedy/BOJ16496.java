package codingtest.greedy;

import java.io.*;
import java.util.*;

public class BOJ16496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(st.nextToken());
        }
        list.sort((s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i));
        }
        if (sb.charAt(0) == '0') {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }
}