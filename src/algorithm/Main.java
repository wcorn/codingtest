package algorithm;

import java.io.*;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Object[] arr;
    static Object[] sortedArr;
    static int N;
    public static void main(String[] args) throws IOException {
        System.out.print("배열의 크기: ");
        N = Integer.parseInt(br.readLine());
        arr = new Object[N];
        sortedArr = new Object[N];
        System.out.println("정렬할 정수를 공백한개로 구분하여 입력");
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println("정렬전 : "+ Arrays.toString(arr));
//        Arrays.sort(arr);

        System.out.println("정렬후: "+ Arrays.toString(arr));
    }
}