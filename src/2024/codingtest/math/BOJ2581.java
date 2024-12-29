package codingtest.math;

import java.io.*;

public class BOJ2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M, N;
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        boolean[] decimal = new boolean[N + 1];
        calculateDecimal(decimal);
        int sum = calculateSum(M, decimal);
        int low = calculateLow(M, decimal);
        if (low == -1)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(low);
        }
    }

    private static int calculateLow(int low, boolean[] decimal) {
        for (int i = low; i < decimal.length; i++) {
            if (!decimal[i])
                return i;
        }
        return -1;
    }

    private static int calculateSum(int low, boolean[] decimal) {
        int sum = 0;
        for (int i = low; i < decimal.length; i++) {
            if (!decimal[i])
                sum += i;
        }

        return sum;
    }

    private static void calculateDecimal(boolean[] decimal) {
        decimal[0] = true;
        decimal[1] = true;
        for (int i = 3; i < decimal.length; i++) {
            for (int j = 2; j <=Math.sqrt(i); j++) {
                if (i % j == 0) {
                    decimal[i] = true;
                    break;
                }
            }
        }
    }
}
