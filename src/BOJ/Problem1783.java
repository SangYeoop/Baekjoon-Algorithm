package BOJ;

import java.util.Scanner;

public class Problem1783 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        int row = 0, col = 0;
        int count = 1;
        if (n >= 3 && m >= 7) {
            count = m - 2;
        }
        else if (n == 2 && m >= 3) {
            m--;
            count = m / 2 + 1;
            if (count > 4)
                count = 4;
        }
        else if (n >= 3 && m >= 2) {
            count = m;
            if (count > 4)
                count = 4;
        }
        System.out.println(count);
    }
}
