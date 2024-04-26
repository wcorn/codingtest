package codingtest.math;

import java.util.*;

public class PGR12938 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
    }

    public static int[] solution(int n, int s) {
        int num = s / n;
        int etc = s % n;
        if (num == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        Arrays.fill(answer, num);
        for (int i = 0; i < etc; i++) {
            answer[n - 1 - i]++;
        }
        return answer;
    }
}
