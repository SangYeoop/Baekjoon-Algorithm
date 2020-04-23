package Implemetation;

import java.util.Scanner;

public class Problem1012 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int k = 0; k < test; k++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int num = sc.nextInt();

            int[][] arr = new int[row + 2][col + 2];
            boolean[][] searched = new boolean[row + 2][col + 2];

            for (int i = 0; i < num; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                arr[++r][++c] = 1;
            }
            int result = 0;
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    if (arr[i][j] == 1 && !searched[i][j]) {
                        dfs(arr, searched, i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void dfs(int[][] arr, boolean[][] searched, int i, int j) {
        if (searched[i][j])
            return;
        searched[i][j] = true;
        if (arr[i + 1][j] == 1)
            dfs(arr, searched, i + 1, j);
        if (arr[i - 1][j] == 1)
            dfs(arr, searched, i - 1, j);
        if (arr[i][j + 1] == 1)
            dfs(arr, searched, i, j + 1);
        if (arr[i][j - 1] == 1)
            dfs(arr, searched, i, j - 1);
    }
}
