import java.io.*;
import java.util.*;

public class BOJ9935 {
    static Stack<Character> list;
    static StringBuilder sb;
    static int boomSize;
    static String str;
    static String boomStr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        list = new Stack<>();
        str = br.readLine();
        boomStr = br.readLine();
        boomSize = boomStr.length();
        solve();
        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }

    private static void solve() {
        boolean flag;
        for (int i = 0; i < str.length(); i++) {
            list.push(str.charAt(i));

            if (list.size() >= boomSize) {
                flag = true;
                for (int j = 0; j < boomSize; j++) {
                    if (list.get(list.size() - (boomSize - j)) != boomStr.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < boomSize; j++) {
                        list.pop();
                    }
                }
            }
        }
    }
}
