package codingtest.datastructure;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class PGR42586 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] progress = Stream.of(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] speeds = Stream.of(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(solution(progress, speeds)));

    }

    private static int[] solution(int[] progresses, int[] speeds) {
        int time = 0;
        int count = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            progressQueue.add(progresses[i]);
            speedQueue.add(speeds[i]);
        }
        while(!progressQueue.isEmpty()){
            time++;
            if(progressQueue.peek()+time*speedQueue.peek()>=100){
                count++;
                progressQueue.remove();
                speedQueue.remove();
                time--;
            }
            else if(count>0){
                answer.add(count);
                count = 0;
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
