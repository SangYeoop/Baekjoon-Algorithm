package Porgrammers;
import java.util.*;

public class 문자열압축 {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(s);

        int len = sb.length();
        int cutSize = 1;

        do{
            StringBuilder temp = new StringBuilder();
            Vector<String> vec = new Vector<>();
            int n = sb.length();
            for(int start = 0; start + cutSize <= len; start += cutSize) {
                vec.add(sb.substring(start, start + cutSize));
                n -= cutSize;
            }
            if(n > 0) {
                vec.add(sb.substring(sb.length() - n, sb.length()));
            }
            int count = 1;
            for(int i = 0; i < vec.size() - 1; i++) {
                if(vec.get(i).equals(vec.get(i + 1)))
                    count++;
                else{
                    if(count != 1)
                        temp.append(count);
                    temp.append(vec.get(i));
                    count = 1;
                }
            }
            if(count != 1)
                temp.append(count);
            temp.append(vec.lastElement());
            min = Math.min(temp.length(), min);
            cutSize++;
        }while (cutSize <= len / 2);


        return min;
    }
}

