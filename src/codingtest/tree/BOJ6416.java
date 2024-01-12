package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ6416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map;
        Set<Integer> vertex;
        boolean flag;
        StringTokenizer st;
        int a, b;
        out:
        for (int tc = 1; ; tc++) {
            map = new HashMap<>();
            vertex = new HashSet<>();
            flag = false;
            st = new StringTokenizer(br.readLine());
            while (true) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if (a == 0)
                    break;
                if (a == -1)
                    break out;
                if (!vertex.add(b)) {
                    flag = true;
                }
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            if (!vertex.isEmpty()) {
                int rootNum = 0;
                for (int num : map.keySet()) {
                    if (!vertex.contains(num)) rootNum++;
                }
                if (rootNum != 1)
                    flag = true;
            }
            if (flag) {
                sb.append("Case ").append(tc).append(" is not a tree.\n");
            } else {
                sb.append("Case ").append(tc).append(" is a tree.\n");
            }
        }
        System.out.println(sb);
    }
}