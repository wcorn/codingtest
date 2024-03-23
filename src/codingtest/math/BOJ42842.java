package codingtest.math;

import java.util.Arrays;

public class BOJ42842 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24, 24)));
    }
    public static int[] solution(int brown, int yellow) {
        int a, b;
        b = ((brown-4)/2+(int)Math.sqrt(Math.pow((brown-4)/2,2)-4*yellow))/2;
        a = yellow/b;
        return new int[] {b+2, a+2};
    }
}
