package BOJ;

import java.util.Scanner;

public class Problem2606 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int edge = sc.nextInt();

        int[][] adj = new int[num + 1][num + 1];
        boolean[] searched = new boolean[num + 1];

        for (int i = 0; i < edge; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from][to] = 1;
            adj[to][from] = 1;
        }

        int start = 1;
        int result = search(adj, start, num, searched);
        System.out.println(result - 1);
    }

    public static int search(int[][] adj, int start, int num, boolean[] searched) {
        int result = 0;
        if (searched[start])
            return 0;
        result++;
        searched[start] = true;
        for(int i = 1; i <= num; i++) {
            if (adj[start][i] == 1 && i != start) {
                result += search(adj, i, num, searched);
            }
        }
        return result;
    }
}
