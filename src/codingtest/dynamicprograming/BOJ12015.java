package codingtest.dynamicprograming;

import java.io.*;
import java.util.*;

public class BOJ12015 {
    private static int N;
    private static int[] A;
    private static List<Integer> sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        sequence = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        A[0] = 0;
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(sequence.size() - 1);
    }

    private static void solve() {
        sequence.add(A[0]);
        int temp;
        for (int i = 1; i <= N; i++) {
            int key = A[i];
            if (sequence.get(sequence.size() - 1) < key) {
                sequence.add(key);
            } else {
                temp = binarySearch(key);
                sequence.set(temp, key);
            }
        }
    }

    private static int binarySearch(int key) {
        int lo = 0;
        int hi = sequence.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (sequence.get(mid) < key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }

        }
        return lo;
    }
}
