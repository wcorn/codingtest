package codingtest.math;

import java.io.*;

public class BOJ2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        char[] N = str[0].toCharArray();
        int a;
        int B = Integer.parseInt(str[1]);
        int answer = 0;
        for (int i = 0; i < N.length; i++) {
            a = cToInt(N[0]);
            answer += (int) (Math.pow(B, N.length - 1 - i) * a);
            System.out.println(answer);
        }
        System.out.println(answer);
    }

    private static int cToInt(char c) {
        System.out.println(c);
        try {
            return Character.getNumericValue(c);
        } catch (Exception e) {
            return (c - '0') - 31;
        }
    }
}