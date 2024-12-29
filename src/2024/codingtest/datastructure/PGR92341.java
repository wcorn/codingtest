package codingtest.datastructure;

import java.util.*;

public class PGR92341 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{180, 5000, 10, 600},new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }
    public static List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<String,Integer> parking = new HashMap<>();
        Map<String,Integer> map = new HashMap<>();
        String[] str;
        String[] temp;
        int time;
        int input;
        for(String record : records){
            str = record.split(" ");
            temp = str[0].split(":");
            time = Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
            if(str[2].equals("IN"))
                parking.put(str[1],time);
            if(str[2].equals("OUT")){
                input = parking.remove(str[1]);
                map.put(str[1],map.getOrDefault(str[1],0)+time-input);
            }
        }
        for(String key: parking.keySet()){
            map.put(key,map.getOrDefault(key,0)+1439-parking.get(key));
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(String carNumber : list){
            int a = (int)(Math.ceil((map.get(carNumber)-fees[0])/(double)fees[2]))*fees[3];
            if(a<0)
                a = 0;
            answer.add(fees[1]+a);
        }
        return answer;
    }
}
