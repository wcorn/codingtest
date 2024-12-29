package codingtest.datastructure;

import java.io.*;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] bracket = br.readLine().toCharArray();
        int count = 0;
        int result = 0;
        for (int i = 0; i < bracket.length; i++) {
            if (bracket[i] == ')') {
                result++;
                count--;
            }
            if (bracket[i] == '(') {
                if (i + 1 < bracket.length) {
                    if (bracket[i + 1] == ')') {
                        result += count;
                        i++;
                    } else {
                        count++;
                    }
                } else {
                    count++;
                }
            }
        }
        System.out.println(result);
    }
}
