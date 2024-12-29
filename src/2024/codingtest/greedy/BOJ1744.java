package codingtest.greedy;

import java.io.*;
import java.util.*;

public class BOJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> positive = new ArrayList<>();
        List<Long> negative = new ArrayList<>();
        long ans = 0;
        long temp;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(br.readLine());
            if (temp <= 0) negative.add(temp);
            else if (temp > 1) positive.add(temp);
            else ans += 1;
        }
        Collections.sort(negative);
        Collections.sort(positive, Collections.reverseOrder());
        int i = 0;
        while (i < negative.size()) {
            if (negative.size() > i + 1)
                ans += (long) negative.get(i++) * negative.get(i++);
            else {
                ans += negative.get(i++);
            }
        }
        i = 0;
        while (i < positive.size()) {
            if (positive.size() > i + 1)
                ans += (long) positive.get(i++) * positive.get(i++);
            else {
                ans += positive.get(i++);
            }
        }
        System.out.println(ans);
    }
}
