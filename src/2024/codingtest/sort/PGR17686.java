package codingtest.sort;

import java.util.*;

public class PGR17686 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
            new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF",
                "img2.JPG"})));
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> list = new ArrayList<>();
        char[] now;
        String head;
        String number;
        String tail;
        int j;
        for (int i = 0; i < files.length; i++) {
            now = files[i].toCharArray();
            j = 0;
            head = "";
            number = "";
            tail = "";
            for (; j < now.length; j++) {
                if (Character.isDigit(now[j])) {
                    break;
                }
                head += now[j];
            }
            for (; j < now.length; j++) {
                if (!Character.isDigit(now[j])) {
                    break;
                }
                number += now[j];
            }
            for (; j < now.length; j++) {
                tail += now[j];
            }
            list.add(new File(head, number, tail));
        }

        Collections.sort(list);
        for (int i = 0; i < files.length; i++) {
            answer[i] = list.get(i).toString();
        }
        return answer;
    }

    public static class File implements Comparable<File> {

        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public String toString() {
            return head + "" + number + "" + tail;
        }

        @Override
        public int compareTo(File file) {
            int result;
            result = head.compareToIgnoreCase(file.head);
            if (result == 0) {
                result = Integer.parseInt(this.number) - Integer.parseInt(file.number);
            }
            return result;
        }
    }
}
