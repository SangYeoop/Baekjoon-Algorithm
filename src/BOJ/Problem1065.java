package BOJ;

import java.util.Scanner;

public class Problem1065 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            char[] arr = String.valueOf(i).toCharArray();
            if (arr.length == 1) {
                count++;
                continue;
            }
            int diff = arr[0] - arr[1];
            boolean check = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (diff != (arr[j] - arr[j + 1])) {
                    check = true;
                    break;
                }
            }
            if (!check)
                count++;
        }
        System.out.println(count);
    }
}
