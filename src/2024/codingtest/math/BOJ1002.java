package codingtest.math;

import java.io.*;
import java.util.*;

public class BOJ1002 {
    private static int T;
    private static int x1, y1, r1, x2, y2, r2;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            solve();
        }
        System.out.println(sb);
    }

    private static void solve() {
        double r3 = Math.abs(r1 - r2);
        double z = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
        if(x1==x2&&y1==y2&&r1==r2)
            sb.append(-1);
        else if (z > r1 + r2)
            sb.append(0);
        else if (r1 + r2 == z)
            sb.append(1);
        else if (z < r1 + r2) {
            if (z > r3)
                sb.append(2);
            else if (z == r3)
                sb.append(1);
            else if (z < r3)
                sb.append(0);
        }
        sb.append("\n");
    }
}
