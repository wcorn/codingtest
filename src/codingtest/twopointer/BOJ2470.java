package codingtest.twopointer;

import java.io.*;
import java.util.*;

public class BOJ2470 {
    private static int N;
    private static List<Integer> list;
    private static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        solve();
        System.out.println(x + " " + y);
    }

    private static void solve() {
        int start = 0;
        int end = N - 1;
        int sum;
        x = list.get(start);
        y = list.get(end);
        while (start < end) {
            sum = list.get(start) + list.get(end);
            if (Math.abs(sum) < Math.abs(x + y)) {
                x = list.get(start);
                y = list.get(end);
            }
            if (sum < 0)
                start++;
            else
                end--;
        }
    }
}
