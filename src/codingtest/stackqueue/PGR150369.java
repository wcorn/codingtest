package codingtest.stackqueue;

import java.util.*;

public class PGR150369 {
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        System.out.println(solution(cap, n, deliveries, pickups));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> delivery = new Stack<>();
        Stack<Integer> pickup = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < deliveries[i]; j++) {
                delivery.push(i + 1);
            }
            for (int j = 0; j < pickups[i]; j++) {
                pickup.push(i + 1);
            }
        }
        int lastD;
        int lastP;
        while (!delivery.isEmpty() && !pickup.isEmpty()) {
            lastD = delivery.peek();
            lastP = pickup.peek();
            for (int i = 0; i < cap; i++) {
                if (!delivery.isEmpty())
                    delivery.pop();
            }
            for (int i = 0; i < cap; i++) {
                if (!pickup.isEmpty())
                    pickup.pop();
            }
            answer += Math.max(lastD, lastP) * 2L;
        }
        while (!delivery.isEmpty()) {
            lastD = delivery.peek();
            for (int i = 0; i < cap; i++)
                if (!delivery.isEmpty())
                    delivery.pop();
            answer += lastD * 2L;
        }
        while (!pickup.isEmpty()) {
            lastP = pickup.peek();
            for (int i = 0; i < cap; i++)
                if (!pickup.isEmpty())
                    answer += lastP * 2L;
        }
        return answer;
    }
}
