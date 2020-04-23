package Implemetation;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem7576 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[n + 2][m + 2];
        boolean[][] visit = new boolean[n + 2][m + 2];
        LinkedList<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < n +2; i++) {
            for (int j = 0; j < m + 2; j++)
                arr[i][j] = -2;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) {
                    Integer[] temp = new Integer[2];
                    temp[0] = i;
                    temp[1] = j;
                    queue.add(temp);
                }
            }
        }
        while(!queue.isEmpty()) {
            Integer[] a = queue.poll();
            bfs(arr, visit, queue, a[0], a[1]);
        }

        int result = 0;
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <=m; j++) {
                if (arr[i][j] == 0) {
                    result = -1;
                    break;
                }
                if (result < arr[i][j])
                    result = arr[i][j] - 1;
            }
            if(result == -1)
                break;
        }
        System.out.println(result);
    }
    public static void bfs(int[][] arr, boolean[][] visit, LinkedList<Integer[]> queue, int i, int j) {
        if (visit[i][j])
            return;
        visit[i][j] = true;
        int[] dx = {-1, 1, 0 ,0};
        int[] dy = {0, 0, -1, 1};

        for(int k = 0; k < 4; k++){
            if (arr[i + dx[k]][j + dy[k]] == 0){
                Integer[] temp = new Integer[2];
                temp[0] = i + dx[k];
                temp[1] = j + dy[k];
                arr[i + dx[k]][j + dy[k]] = arr[i][j] + 1;
                queue.add(temp);
            }
        }
    }
}
