package codingtest.stackqueue;

import java.io.*;
import java.util.*;

public class BOJ2065 {
    private static int M;
    private static int t;
    private static int N;
    private static Queue<Customer> now;
    private static Queue<Customer> opposite;
    private static List<Integer> c;
    private static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        now = new LinkedList<>();
        opposite = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        c = new ArrayList<>(N);
        int temp;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            temp = Integer.parseInt(st.nextToken());
            if (st.nextToken().equals("left"))
                now.add(new Customer(i, temp));
            else
                opposite.add(new Customer(i, temp));
            c.add(0);
        }
        solve();
        for (int i = 0; i < N; i++) {
            sb.append(c.get(i)).append("\n");
        }
        System.out.println(sb);

    }

    private static void solve() {
        time = 0;
        while (!now.isEmpty() || !opposite.isEmpty()) {
            selectMarina();
            calculateTime();
            getCustomer();
        }
    }

    private static void getCustomer() {
        int num = 0;
        Queue<Integer> a = new LinkedList<>();
        while ((!now.isEmpty() && num < M) && now.peek().time <= time) {
            a.add(now.poll().num);
            num++;
        }
        if (num != 0) {
            move();
            while (!a.isEmpty()) {
                c.set(a.poll(), time);
            }
        }

    }

    private static void calculateTime() {
        if (now.isEmpty())
            return;
        if (time < now.peek().time) {
            time = now.peek().time;
        }
    }

    private static void selectMarina() {
        if (now.isEmpty() && !opposite.isEmpty()) {
            if (time < opposite.peek().time)
                time = opposite.peek().time;
            move();
            return;
        }
        if (opposite.isEmpty())
            return;
        if (now.peek().time <= time)
            return;
        if (now.peek().time > opposite.peek().time) {
            if (time < opposite.peek().time)
                time = opposite.peek().time;
            move();
        }
    }

    private static void move() {
        time += t;
        swapQueue();
    }

    private static void swapQueue() {
        Queue<Customer> temp;
        temp = now;
        now = opposite;
        opposite = temp;
    }

    private static class Customer {
        int num;
        int time;

        Customer(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}