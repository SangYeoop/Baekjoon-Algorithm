package Implemetation;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem2206 {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][][] visit = new boolean[n + 2][m + 2][2];
        char[][] arr = new char[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = s.charAt(j - 1);
            }
        }
        LinkedList<Stream> queue = new LinkedList<>();
        queue.offer(new Stream(1, 1, 1, 0));
        visit[1][1][0] = true;
        int result = -1;

        while (!queue.isEmpty()) {
            Stream s = queue.poll();
            if (s.row == n && s.col == m) {
                result = s.distance;
                break;
            }
            if (arr[s.row + 1][s.col] == '0' && !visit[s.row + 1][s.col][s.isDestroy]) {
                visit[s.row + 1][s.col][s.isDestroy] = true;
                queue.add(new Stream(s.row + 1, s.col, s.distance + 1, s.isDestroy));
            } else if (arr[s.row + 1][s.col] == '1' && s.isDestroy == 0 && !visit[s.row + 1][s.col][s.isDestroy]) {
                visit[s.row + 1][s.col][s.isDestroy] = true;
                queue.add(new Stream(s.row + 1, s.col, s.distance + 1, 1));
            }

            if (arr[s.row - 1][s.col] == '0' && !visit[s.row - 1][s.col][s.isDestroy]) {
                visit[s.row - 1][s.col][s.isDestroy] = true;
                queue.add(new Stream(s.row - 1, s.col, s.distance + 1, s.isDestroy));
            } else if (arr[s.row - 1][s.col] == '1' && s.isDestroy == 0 && !visit[s.row - 1][s.col][s.isDestroy]) {
                visit[s.row - 1][s.col][s.isDestroy] = true;
                queue.add(new Stream(s.row - 1, s.col, s.distance + 1, 1));
            }

            if (arr[s.row][s.col + 1] == '0' && !visit[s.row][s.col + 1][s.isDestroy]) {
                visit[s.row][s.col + 1][s.isDestroy] = true;
                queue.add(new Stream(s.row, s.col + 1, s.distance + 1, s.isDestroy));
            } else if (arr[s.row][s.col + 1] == '1' && s.isDestroy == 0 && !visit[s.row][s.col + 1][s.isDestroy]) {
                visit[s.row][s.col + 1][s.isDestroy] = true;
                queue.add(new Stream(s.row, s.col + 1, s.distance + 1, 1));
            }

            if (arr[s.row][s.col - 1] == '0' && !visit[s.row][s.col - 1][s.isDestroy]) {
                visit[s.row][s.col - 1][s.isDestroy] = true;
                queue.add(new Stream(s.row, s.col - 1, s.distance + 1, s.isDestroy));
            } else if (arr[s.row][s.col - 1] == '1' && s.isDestroy == 0 && !visit[s.row][s.col - 1][s.isDestroy]) {
                visit[s.row][s.col - 1][s.isDestroy] = true;
                queue.add(new Stream(s.row, s.col - 1, s.distance + 1, 1));
            }
        }
        System.out.println(result);
    }

    static class Stream {
        public int row;
        public int col;
        public int isDestroy;
        public int distance;

        public Stream(int row, int col, int distance, int isDestroy) {
            this.row = row;
            this.col = col;
            this.distance = distance;
            this.isDestroy = isDestroy;
        }
    }
}
