package codingtest.math;

import java.io.*;
import java.util.*;

public class BOJ13172 {
    private static int M;
    private static Queue<Dice> list;
    private static final int MOD = 1000000007;
    private static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new LinkedList<>();
        StringTokenizer st;
        result = 0;
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Dice(Integer.parseInt(st.nextToken())%MOD, Integer.parseInt(st.nextToken())%MOD));
        }
        solve();
        System.out.println(result);
    }

    private static void solve() {
        Dice temp;
        while (!list.isEmpty()) {
            temp = list.poll();
            temp.diceGcd();
            temp.calculateInverseN();
            result = (result+temp.S * temp.inverseN) % MOD;
        }
    }

    private static class Dice {
        long N;
        long S;
        long inverseN;

        public Dice(int N, int S) {
            this.N = N;
            this.S = S;
        }

        public void diceGcd() {
            long gcd = gcd(N, S);
            N = N / gcd;
            S = S / gcd;
        }

        private long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        public void calculateInverseN() {
            inverseN = calculate(N, MOD - 2);
        }

        private static long calculate(long N, int index) {
            if (index == 1)
                return N;
            long temp = calculate(N, index / 2);
            if (index % 2 == 1)
                return temp * temp % MOD * N % MOD;
            else
                return temp * temp % MOD;

        }
    }
}
