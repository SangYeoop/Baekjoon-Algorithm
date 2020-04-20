package Implemetation;

import java.util.Scanner;

public class Problem1236 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int r, c;
        r = sc.nextInt();
        c = sc.nextInt();
        Boolean[][] state = new Boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                if (s.charAt(j) == '.')
                    state[i][j] = false;
                else if (s.charAt(j) == 'X')
                    state[i][j] = true;
            }
        }

        int count1 = 0, count2 = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++) {
                if (state[i][j])
                    break;
                if (j == c - 1)
                    count1++;
            }
        }

        for(int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++){
                if(state[j][i])
                    break;
                if(j == r - 1)
                    count2++;
            }
        }
        int result = Math.max(count1, count2);
        System.out.println(result);
    }
}
