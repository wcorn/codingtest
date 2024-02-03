package codingtest.greedy;

import java.io.*;

public class BOJ2720 {
    private static final int Quarter = 25;
    private static final int Dime = 10;
    private static final int Nickel = 5;
    private static final int Penny = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());
            sb.append(C / Quarter).append(" ");
            C %= Quarter;
            sb.append(C / Dime).append(" ");
            C %= Dime;
            sb.append(C / Nickel).append(" ");
            C %= Nickel;
            sb.append(C / Penny).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
