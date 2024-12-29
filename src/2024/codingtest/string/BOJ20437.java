package codingtest.string;

import java.io.*;
import java.util.*;

public class BOJ20437 {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String W;
        int K;
        for (int i = 0; i < T; i++) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());
            solve(W, K - 1);
        }
        System.out.println(sb);
    }

    private static void solve(String w, int k) {
        char[] ch = w.toCharArray();
        int index;
        int min = ch.length;
        int max = 0;
        List<Integer> now;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>());
        }
        boolean isHave = false;
        for (int i = 0; i < ch.length; i++) {
            index = ch[i] - 97;
            list.get(index).add(i);
        }
        for (int i = 0; i < 26; i++) {
            now = list.get(i);
            for (int j = 0; j < now.size() - k; j++) {
                int a = j + k;
                min = Math.min(min, now.get(a) - now.get(j) + 1);
                max = Math.max(max, now.get(a) - now.get(j) + 1);
                isHave = true;
            }
        }

        if (isHave) {
            sb.append(min).append(" ").append(max).append("\n");
        } else
            sb.append("-1").append("\n");
    }
}
