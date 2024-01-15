package codingtest.string;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ20210 {
    private static int N;
    private static List<List<String>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]|[0-9]+");
        Matcher matcher;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            matcher = pattern.matcher(br.readLine());
            List<String> input = new ArrayList<>();
            while (matcher.find()) {
                input.add(matcher.group());
            }
            list.add(input);
        }
        solve();
        for (List<String> strings : list) {
            for (String string : strings) {
                sb.append(string);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void solve() {
        list.sort((o1, o2) -> {
            int len1 = o1.size();
            int len2 = o2.size();
            int cnt1, cnt2;
            char c1, c2;
            int i = 0, j = 0;
            for (; i < len1 && j < len2; i++, j++) {
                if (o1.get(i).equals(o2.get(j)))
                    continue;
                boolean isNumeric1 = Character.isDigit(o1.get(i).charAt(0));
                boolean isNumeric2 = Character.isDigit(o2.get(j).charAt(0));
                if (isNumeric1 && isNumeric2) {
                    cnt1 = countZero(o1.get(i));
                    cnt2 = countZero(o2.get(i));
                    String num1 = o1.get(i).substring(cnt1);
                    String num2 = o2.get(i).substring(cnt2);
                    if (num1.length() > num2.length())
                        return 1;
                    if (num2.length() > num1.length())
                        return -1;
                    for (int a = 0, b = 0; a < num1.length() && b < num2.length(); a++, b++) {
                        if (num1.charAt(a) > num2.charAt(b))
                            return 1;
                        else if (num1.charAt(a) < num2.charAt(b))
                            return -1;
                    }
                    if (cnt1 != cnt2)
                        return cnt1 - cnt2;
                }
                if (!isNumeric1 && !isNumeric2) {
                    c1 = o1.get(i).charAt(0);
                    c2 = o2.get(j).charAt(0);
                    if (c1 == c2)
                        continue;
                    boolean isUpper1 = c1 - 'a' < 0;
                    boolean isUpper2 = c2 - 'a' < 0;
                    int n1 = c1 - 'a' >= 0 ? c1 - 'a' : c1 - 'A';
                    int n2 = c2 - 'a' >= 0 ? c2 - 'a' : c2 - 'A';
                    if ((isUpper1 && isUpper2) || (!isUpper1 && !isUpper2)) {
                        return n1 - n2;
                    }
                    if (!isUpper1 && isUpper2) {
                        if (n1 == n2)
                            return 1;
                        return n1 - n2;
                    } else if (isUpper1 && !isUpper2) {
                        if (n1 == n2)
                            return -1;
                        return n1 - n2;
                    }
                }
                if (!isNumeric1 && isNumeric2) {
                    return 1;
                }
                if (isNumeric1 && !isNumeric2) {
                    return -1;
                }
            }
            if (len1 != i) {
                return 1;
            }
            if (len2 != j) {
                return -1;
            }
            return 0;
        });

    }

    public static int countZero(String str) {
        char[] chs = str.toCharArray();
        int cnt = 0;
        for (char ch : chs) {
            if (ch == '0')
                cnt++;
            else
                break;
        }
        return cnt;
    }
}
