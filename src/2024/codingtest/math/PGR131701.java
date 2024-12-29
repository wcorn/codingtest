package codingtest.math;

public class PGR131701 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,9,1,1,4}));
    }
    public static int solution(int[] elements) {
        int answer = 0;
        int size=0;
        int[] e = new int[elements.length*2];
        for(int i=0;i<elements.length;i++){
            size+=elements[i];
            e[i] = elements[i];
        }
        for(int i=0;i<elements.length-1;i++){
            e[elements.length+i] = elements[i];
        }
        boolean[] seq = new boolean[size+1];
        int now;
        for(int i=1;i<=elements.length;i++){
            for(int j=0; j<=elements.length; j++){
                now = 0;
                for(int k=0;k<i;k++){
                    now+=e[j+k];
                }
                seq[now] = true;
            }
        }
        for(int i=0;i<seq.length;i++){
            if(seq[i])
                answer++;
        }
        return answer;
    }
}
