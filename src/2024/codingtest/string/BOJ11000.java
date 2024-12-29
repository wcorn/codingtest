package codingtest.string;

import java.io.*;
import java.util.*;

public class BOJ11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }
        Arrays.sort(lectures, new Comparator<>() {
            @Override
            public int compare(Lecture l1, Lecture l2) {
                if (l1.start == l2.start)
                    return l1.end - l2.end;
                return l1.start - l2.start;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].start) {
                pq.remove();
            }
            pq.add(lectures[i].end);
        }
        System.out.println(pq.size());
    }

    private static class Lecture {
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
