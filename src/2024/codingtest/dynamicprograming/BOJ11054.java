package codingtest.dynamicprograming;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class BOJ11054 {
    static int N;
    static int[] sequence;
    static int[] increase;
    static int[] increase_reverse;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        increase = new int[N];
        increase_reverse = new int[N];
        sequence = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solve();
        System.out.println(result);
    }

    private static void solve() {
        Arrays.fill(increase,1);
        Arrays.fill(increase_reverse,1);
        //increase
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    increase[i] = Math.max(increase[i], increase[j] + 1);
                }
                else if(sequence[i] == sequence[j]){
                    increase[i] = increase[j];
                }
            }
        }
        //decrease_reverse
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= i; j--) {
                if (sequence[i] > sequence[j]) {
                    increase_reverse[i] = Math.max(increase_reverse[i], increase_reverse[j] + 1);
                }
                else if(sequence[i] == sequence[j]){
                    increase_reverse[i] = increase_reverse[j];
                }
            }
        }
        for(int i=0;i<N;i++){
            result = Math.max(result,increase[i]+increase_reverse[i]-1);
        }
    }
}
