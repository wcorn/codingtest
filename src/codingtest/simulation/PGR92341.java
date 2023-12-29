package codingtest.simulation;

import java.util.*;


public class PGR92341 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(solution(fees, records));
    }

    public static List<Integer> solution(int[] fees, String[] records) {
        HashMap<String, Integer> park = new HashMap<>();
        TreeMap<String, Integer> costs = new TreeMap<>();
        String[] record;
        String[] times;
        int time;

        for (int i = 0; i < records.length; i++) {
            record = records[i].split(" ");
            times = record[0].split(":");
            time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            if (record[2].equals("IN")) {
                park.put(record[1], time);
            } else if (record[2].equals("OUT")) {
                if (!costs.containsKey(record[1])) {
                    costs.put(record[1], time - park.get(record[1]));
                } else {
                    costs.put(record[1], costs.get(record[1]) + time - park.get(record[1]));
                }
                park.remove(record[1]);
            }
        }
        if (!park.isEmpty()) {
            for (String carNum : park.keySet()) {
                Integer cost = costs.get(carNum);
                cost = (cost == null) ? 0 : cost;
                costs.put(carNum, cost + (23 * 60 + 59) - park.get(carNum));
            }
        }
        List<Integer> answer = new ArrayList<>();
        Iterator<Integer> iterator = costs.values().iterator();
        int a;
        while (iterator.hasNext()) {
            a = iterator.next();
            if (a <= fees[0]) {
                answer.add(fees[1]);
            } else {
                answer.add((int) (fees[1] + Math.ceil((double) (a - fees[0]) / fees[2]) * fees[3]));
            }
        }
        return answer;
    }
}
