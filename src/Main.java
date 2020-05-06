import Porgrammers.파일명정렬;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        파일명정렬 a = new 파일명정렬();
        String[] s = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        s = a.solution(s);

        for (int i = 0; i  < s.length; i++){
            System.out.println(s[i]);
        }
    }
}

