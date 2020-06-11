package BOJ;

import java.util.Scanner;

public class Problem15953 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = {5000000, 3000000, 2000000, 500000, 300000, 100000};
        int[] arr2 = {5120000, 2560000, 1280000, 640000, 320000};

        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            int result = 0;

            if (first == 1)
                result += arr1[0];
            else if (first >= 2 && first <= 3)
                result += arr1[1];
            else if (first >= 4 && first <= 6)
                result += arr1[2];
            else if (first >= 7 && first <= 10)
                result += arr1[3];
            else if (first >= 11 && first <= 15)
                result += arr1[4];
            else if (first >= 16 && first <= 21)
                result += arr1[5];

            if (second == 1)
                result += arr2[0];
            if (second >= 2 && second <= 3)
                result += arr2[1];
            if (second >= 4 && second <= 7)
                result += arr2[2];
            if (second >= 8 && second <= 15)
                result += arr2[3];
            if (second >= 16 && second <= 31)
                result += arr2[4];
            System.out.println(result);
        }
    }
}
