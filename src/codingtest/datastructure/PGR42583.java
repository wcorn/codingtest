package codingtest.datastructure;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 * 다리를 지나는 트럭 스택/큐
 * 문제 주요 조건 트럭이 다리를 건널때 두 트럭 사이의 차이 나는 시간을 어떻게 할 것인가....
 * 앞차의 경우 이미 트럭에 올라타서 지나가고 있지만 무게 때문에 다음 차가 다리에 올라가지 못한다면
 * -> 그 경우 트럭이 아닌 임의의 숫자를 다리에 올려 놓는다 ex) 0
 * 그렇다면 무게가 되서 다음 트럭이 올라가더라도 두 트럭 사이에 이미 지난 시간 만큼의 0이 있을테니 pop을 통해 지나가는 시간 획득 가능
 */
public class PGR42583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bridge_length = Integer.parseInt(br.readLine());
        int weight = Integer.parseInt(br.readLine());
        int[] truck_weights = Stream.of(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer;
        Queue<Integer> q = new LinkedList<>();
        int bridgeWeight = 0;
        int truck;
        int time = 0;
        for (int truckWeight : truck_weights) {
            truck = truckWeight;
            while (true) {
                //다리가 꽉차 있을때
                if (q.size() == bridge_length) {
                    bridgeWeight -= q.remove();
                }
                //다리에 트럭이 꽉차 있지 않을때
                else {
                    //들어올 트럭이 무게를 넘지 않을 경우
                    if (bridgeWeight + truck <= weight) {
                        q.add(truck);
                        time++;
                        bridgeWeight += truck;
                        break;
                    }
                    //무게를 넘을 경우
                    else {
                        q.add(0);
                        time++;
                    }
                }
            }
        }
        answer = time + bridge_length;
        return answer;
    }
}
