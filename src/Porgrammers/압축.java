package Porgrammers;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class 압축 {

    public int[] solution(String msg) {
        Vector<Integer> answer = new Vector<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= 26; i++) {
            char c = (char)(i + 'A' - 1);
            String s = String.valueOf(c);
            map.put(s, i);
        }
        int idx = 27;
        StringBuilder sb = new StringBuilder(msg);
        while(!sb.toString().equals("")) {
            int count = 1;
            while(true) {
                String substr = sb.substring(0, count);
                if (map.containsKey(substr)) {
                    count++;
                } else{
                    answer.add(map.get(sb.substring(0, count - 1)));
                    map.put(substr, idx++);
                    sb.delete(0, count - 1);
                    break;
                }
                if (substr.equals(sb.toString())) {
                    answer.add(map.get(substr));
                    sb.delete(0, count);
                    break;
                }
            }
        }
        int[] an = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            an[i] = answer.get(i);
        }
        return an;
    }
}
