package codingtest.string;

import java.util.*;
import java.io.*;

public class BOJ25206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double answer = 0;
        double grade;
        double degree;
        String str;
        int count = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            grade = Double.parseDouble(st.nextToken());
            str = st.nextToken();
            if (str.equals("P"))
                continue;
            degree = change(str);
            answer += grade * degree;
            count += (int) grade;
        }
        System.out.println(answer / count);
    }

    private static double change(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            default:
                return 0.0;
        }
    }
}
