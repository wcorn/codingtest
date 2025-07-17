package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/1747"> 소수&팰린드롬 </a>
 */
public class BOJ1747 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            N = 2;
        }
        for (int i = N; i <= 10_000_000; i++) {
            if (!isPrime(i)) {
                continue;
            }
            if (!isPalindrome(i)) {
                continue;
            }
            System.out.println(i);
            break;
        }
    }

    private static boolean isPrime(int num) {
        int t = (int) Math.sqrt(num);
        for (int i = 2; i <= t; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int num) {
        String n1 = Integer.toString(num);
        String n2 = new StringBuilder(n1).reverse().toString();
        for (int i = 0; i < n1.length(); i++) {
            if (n1.charAt(i) != n2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
