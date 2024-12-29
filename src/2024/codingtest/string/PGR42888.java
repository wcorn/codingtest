package codingtest.string;

import java.util.*;

public class PGR42888 {
    private final static String ENTER= "님이 들어왔습니다.";
    private final static String LEAVE= "님이 나갔습니다.";
    public static void main(String[] args){
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(record));
    }
    public static List<String> solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int count = 0;

        for(int i = 0; i < record.length; i++){
            String[] info = record[i].split(" ");

            if(info[0].equals("Leave")){
                continue;
            } else if(info[0].equals("Enter")){
                map.put(info[1], info[2]);
            } else {
                map.put(info[1], info[2]);
                count++;
            }
        }
        List<String> answer = new ArrayList();
        for(int i = 0; i < record.length; i++){
            String[] info = record[i].split(" ");
            String nickname = map.get(info[1]);

            if(info[0].equals("Enter")){
                answer.add(nickname + ENTER);
            } else if(info[0].equals("Leave")){
                answer.add(nickname + LEAVE);
            }
        }

        return answer;
    }
}
