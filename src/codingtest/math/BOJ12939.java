package codingtest.math;
import java.util.*;
public class BOJ12939 {
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
    }
    public static String solution(String s) {
        String[] arr = s.split(" ");
        int[] arr2 = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr2[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(arr2);
        return arr2[0]+" "+arr2[arr2.length-1];
    }
}
