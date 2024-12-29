package codingtest.string;

import java.io.*;

public class BOJ4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        boolean flag;
        char[] ch;
        char prev;
        int count;
        while (!(input = br.readLine()).equals("end")) {
            ch = input.toCharArray();
            flag = false;
            prev = ' ';
            count = 0;
            for (int i = 0; i < ch.length; i++) {
                if (isVowel(ch[i]))
                    flag = true;
                if (isVowel(ch[i]) != isVowel(prev))
                    count = 1;
                else
                    count++;
                if (count > 2 || (prev == ch[i] && (ch[i] != 'e' && ch[i] != 'o'))) {
                    flag = false;
                    break;
                }
                prev = ch[i];
            }
            if (flag)
                sb.append("<").append(input).append("> is acceptable.\n");
            else
                sb.append("<").append(input).append("> is not acceptable.\n");
        }
        System.out.println(sb);
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
