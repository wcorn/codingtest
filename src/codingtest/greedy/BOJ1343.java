package codingtest.greedy;

import java.io.*;

public class BOJ1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] board = br.readLine().toCharArray();
        int count = 0;
        int num;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '.') {
                num = count % 4;
                if (num % 2 == 1) {
                    System.out.println(-1);
                    return;
                }
                for (int j = 0; j < count / 4; j++) {
                    sb.append("AAAA");
                }
                if (num == 2)
                    sb.append("BB");
                count = 0;
                sb.append(".");
            } else
                count++;
        }
        num = count % 4;
        if (num % 2 == 1) {
            System.out.println(-1);
            return;
        }
        for (int j = 0; j < count / 4; j++) {
            sb.append("AAAA");
        }
        if (num == 2)
            sb.append("BB");
        System.out.println(sb);
    }
}
