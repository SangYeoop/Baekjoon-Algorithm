package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem2178 {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        char[][] arr = new char[row + 2][col + 2];
        boolean[][] searched = new boolean[row + 2][col + 2];
        for (int i = 1; i <= row; i++) {
            String s = sc.next();
            for (int j = 1; j <= col; j++) {
                arr[i][j] = s.charAt(j - 1);
            }
        }
        int[][] arrI = new int[row +2][col + 2];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                arrI[i][j] =  arr[i][j] - '0';
            }
        }

        LinkedList<Integer[]> queue = new LinkedList<>();
        Integer[] i = new Integer[2];
        i[0] = 1;
        i[1] = 1;
        queue.add(i);
        while (!queue.isEmpty()) {
            Integer[] temp = queue.poll();
            if (temp[0] == row && temp[1] == col) {
                System.out.println(arrI[row][col]);
                break;
            }
            bfs(arrI, searched, queue, temp[0], temp[1]);
        }
    }

    public static void bfs(int[][] arr, boolean[][] searched, LinkedList<Integer[]> queue, int i, int j) {
        if (searched[i][j])
            return;
        searched[i][j] = true;
        if (arr[i + 1][j] >= 1) {
            arr[i + 1][j] = arr[i][j] + 1;
            Integer[] temp = new Integer[2];
            temp[0] = i + 1;
            temp[1] = j;
            queue.add(temp);
        }
        if (arr[i - 1][j] >= 1) {
            arr[i - 1][j] = arr[i][j] + 1;
            Integer[] temp = new Integer[2];
            temp[0] = i - 1;
            temp[1] = j;
            queue.add(temp);
        }
        if (arr[i][j + 1] >= 1) {
            arr[i][j + 1] = arr[i][j] + 1;
            Integer[] temp = new Integer[2];
            temp[0] = i;
            temp[1] = j + 1;
            queue.add(temp);
        }
        if (arr[i][j - 1] >= 1) {
            arr[i][j - 1] = arr[i][j] + 1;
            Integer[] temp = new Integer[2];
            temp[0] = i;
            temp[1] = j - 1;
            queue.add(temp);
        }
    }
}
