package codingtest.math;

import java.util.*;
import java.io.*;

public class BOJ3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Map<Integer, Integer> dx = new HashMap<>();
        Map<Integer, Integer> dy = new HashMap<>();
        int x, y;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (dx.get(x) == null)
                dx.put(x, 1);
            else
                dx.put(x, dx.get(x) + 1);
            if (dy.get(y) == null)
                dy.put(y, 1);
            else
                dy.put(y, dy.get(y) + 1);
        }
        Set<Integer> temp = dx.keySet();
        Iterator<Integer> iterator = temp.iterator();
        int a;
        while (iterator.hasNext()) {
            a = iterator.next();
            if (dx.get(a) == 1)
                sb.append(a).append(" ");
        }
        temp = dy.keySet();
        iterator = temp.iterator();
        while (iterator.hasNext()) {
            a = iterator.next();
            if (dy.get(a) == 1)
                sb.append(a);
        }
        System.out.print(sb);
    }
}
