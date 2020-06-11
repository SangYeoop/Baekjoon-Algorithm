package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem7569 {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int b = sc.nextInt();

        int[][][] arr = new int[b + 2][n + 2][m + 2];
        boolean[][][] visit = new boolean[b + 2][n + 2][m + 2];
        LinkedList<Integer[]> queue = new LinkedList<>();

        for (int k = 0; k < b + 2; k++) {
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < m + 2; j++) {
                    arr[k][i][j] = -2;
                    visit[k][i][j] = false;
                }
            }
        }

        for (int k = 1; k <= b; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    arr[k][i][j] = sc.nextInt();
                    if (arr[k][i][j] == 1) {
                        visit[k][i][j] = true;
                        Integer[] temp = new Integer[3];
                        temp[0] = i;
                        temp[1] = j;
                        temp[2] = k;
                        queue.add(temp);
                    }
                }
            }
        }

        int result = 0;
        if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        }
        while (!queue.isEmpty()) {
            Integer[] a = queue.poll();
            bfs(arr, visit, queue, a[0], a[1], a[2]);
        }

        for (int k = 1; k <= b; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (arr[k][i][j] == 0) {
                        result = -1;
                        break;
                    }
                    if (result < arr[k][i][j])
                        result = arr[k][i][j] - 1;
                }
                if (result == -1)
                    break;
            }
            if (result == -1)
                break;
        }
        System.out.println(result);
    }

    public static void bfs(int[][][] arr, boolean[][][] visit, LinkedList<Integer[]> queue, int i, int j, int b) {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        for (int k = 0; k < 6; k++) {
            if (arr[b + dz[k]][i + dx[k]][j + dy[k]] == 0 && !visit[b + dz[k]][i + dx[k]][j + dy[k]]) {
                visit[b + dz[k]][i + dx[k]][j + dy[k]] = true;
                Integer[] temp = new Integer[3];
                temp[0] = i + dx[k];
                temp[1] = j + dy[k];
                temp[2] = b + dz[k];
                arr[b + dz[k]][i + dx[k]][j + dy[k]] = arr[b][i][j] + 1;
                queue.add(temp);
            }
        }
    }
}
