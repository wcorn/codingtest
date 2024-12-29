package codingtest.dynamicprograming;

import java.util.*;
import java.io.*;

/**
 * 1. 기존에 number가 1인 것부터 찾아서 올라가는 식으로 하려함
 * 2. 하지만 아무리 찾아도 규칙을 찾는 것이 불가능
 * 3. 그러다 최솟값이 8보다 크면 -1 return을 보고 N을 몇번 사용했는지로 노선 변경
 * 4. 그렇게 다시 생각하니 사칙연산 적용하는 방법이 보임
 * 역시 발상의 전환
 */
public class PGR42895 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int number = Integer.parseInt(br.readLine());
        System.out.println(solution(N, number));
    }

    public static int solution(int N, int number) {
        Set<Integer> now;
        ArrayList<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        for (int i = 1; i <= 8; i++) {
            dp.add(new HashSet<>());
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        for (int i = 1; i <= 8; i++) {
            now = dp.get(i);
            for (int j = 1; j < i; j++) {
                for (Integer a : dp.get(j)) {
                    for (Integer b : dp.get(i - j)) {
                        now.add(a + b);
                        now.add(a - b);
                        now.add(b - a);
                        now.add(a * b);
                        if (a != 0) {
                            now.add(b / a);
                        }
                    }
                }
            }
            if (now.contains(number)) {
                return i;
            }
        }
        return -1;
    }
}
