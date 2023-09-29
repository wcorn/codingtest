package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ16953 {
    static long A;
    static long B;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        result = 0;
        System.out.println(solve());
    }

    private static long solve() {
        Queue<Long> q = new LinkedList<>();
        long temp;
        int size;
        q.add(A);
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                temp = q.poll();
                if (temp == B) {
                    return result + 1;
                }
                if (temp < B) {
                    q.add(temp * 2);
                    q.add(temp*10+1);
                }
            }
            result++;
        }
        return -1;
    }
}
