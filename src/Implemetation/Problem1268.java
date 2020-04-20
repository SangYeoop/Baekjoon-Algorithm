package Implemetation;

import java.util.Scanner;

public class Problem1268 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int num;
        num = sc.nextInt();

        int[][] arr = new int[num][5];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] relation = new int[num][num];

        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        relation[i][j] = 1;
                        relation[j][i] = 1;
                    }
                }
            }
        }

        int max = 0;
        int maxI = 0;
        int count = 0;
        for (int i = 0; i < num; i++) {
            count = 0;
            for (int j = 0; j < num; j++) {
                if (relation[i][j] == 1)
                    count++;
            }
            if (max < count) {
                max = count;
                maxI = i;
            }
        }
        System.out.println(maxI + 1);
    }
}
