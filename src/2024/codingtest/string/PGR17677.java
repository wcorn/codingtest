package codingtest.string;

import java.util.*;

public class PGR17677 {
    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> list1 = duplicate(str1);
        List<String> list2 = duplicate(str2);
        if (list1.isEmpty() && list2.isEmpty())
            return 65536;
        int count = 0;
        String str;
        for (int i = 0; i < list1.size(); i++) {
            str = list1.get(i);
            if (list2.contains(str)) {
                list1.remove(str);
                list2.remove(str);
                count++;
                i--;
            }
        }
        return (int) ((double) count / (count + list1.size() + list2.size()) * 65536);
    }

    private static List<String> duplicate(String str) {
        List<String> list = new ArrayList<>();
        char a;
        char b;
        for (int i = 0; i < str.length() - 1; i++) {
            a = str.charAt(i);
            b = str.charAt(i + 1);
            if (a < 97 || a > 122 || b < 97 || b > 122)
                continue;
            list.add(a + "" + b);
        }
        return list;
    }
}
