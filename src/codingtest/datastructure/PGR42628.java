package codingtest.datastructure;

import java.util.*;

public class PGR42628 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 1", "I 2", "D 1", "D -1", "I 3", "I 4", "D 1"})));
    }
    public static int[] solution(String[] operations) {
        String[] now;
        int length=0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int a;
        for(int i=0;i<operations.length;i++){
            now = operations[i].split(" ");
            if(now[0].equals("I")) {
                a = Integer.parseInt(now[1]);
                minHeap.add(a);
                maxHeap.add(a);
                length++;
            }
            else if(length>0&&now[1].equals("1")) {
                length--;
                minHeap.remove(maxHeap.remove());
            }
            else if(length>0&&now[1].equals("-1")) {
                length--;
                maxHeap.remove(minHeap.remove());
            }
        }
        if(length<=0)
            return new int[]{0,0};
        return new int[]{maxHeap.remove(),minHeap.remove()};
    }
}
