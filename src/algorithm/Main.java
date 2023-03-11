package algorithm;

import org.w3c.dom.Node;

import java.io.*;
import java.util.Arrays;

import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //객체 비교힐 떼 사용할 Comparator
    private static class objectComparator implements Comparator<object> {
        //x먼저 비교 후 x 같으면 y 비교
        @Override
        public int compare(object a, object b) {
            if (a.x > b.x) return 1;
            else if (a.x < b.x) return -1;
            else if (a.y > b.y) return 1;
            else if (a.y < b.y) return -1;
            return 0;
        }

    }

    static class object {
        int x;
        int y;

        object(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        //정수 비교할지 객체 비교할지 선택
        System.out.println("정수 1 객체 2");
        int num = Integer.parseInt(br.readLine());
        if (num == 1) {
            intSequence();
        }
        if (num == 2) {
            objectSequence();
        }
    }

    private static void intSequence() throws IOException {
        System.out.print("배열의 크기: ");
        int N = Integer.parseInt(br.readLine());
        Object[] arr = new Object[N];
        System.out.println("정렬할 정수를 공백한개로 구분하여 입력");
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println("정렬전 : " + Arrays.toString(arr));
        MergeSort.sort(arr);

        System.out.println("정렬후: " + Arrays.toString(arr));
    }

    private static void objectSequence() throws IOException {
        System.out.print("배열의 크기: ");
        int N = Integer.parseInt(br.readLine());
        int x;
        int y;
        object[] arr = new object[N];
        for (int i = 0; i < N; i++) {
            System.out.print("객체 [" + (i + 1) + "]: ");
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[i] = new object(x, y);
        }
        System.out.println("정렬전 : " + Arrays.toString(arr));
        MergeSort.sort(arr,new objectComparator());
        System.out.println("정렬후: " + Arrays.toString(arr));

    }
}