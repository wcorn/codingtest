package codingtest.datastructure;

import java.util.*;

public class PGR42888 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}));
    }

    public static List<String> solution(String[] record) {
        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        List<Answer> answer = new ArrayList<>();
        String[] str;
        for(int i=0;i<record.length;i++){
            str = record[i].split(" ");
            if(str[0].equals("Enter")){
                map.put(str[1],str[2]);
                answer.add(new Answer(str[1],"님이 들어왔습니다."));
            }
            if(str[0].equals("Leave")){
                answer.add(new Answer(str[1],"님이 나갔습니다."));
            }
            if(str[0].equals("Change")){
                map.put(str[1],str[2]);
            }
        }
        for(Answer value : answer){
            result.add(map.get(value.id)+value.message);
        }
        return result;
    }
    public static class Answer {
        String id;
        String message;
        public Answer(String id, String message){
            this.id = id;
            this.message = message;
        }

    }
}
