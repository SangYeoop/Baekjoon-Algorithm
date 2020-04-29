package BOJ;

import java.util.Scanner;

public class Problem15650 {

    public static void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] selected = new int[m];
        boolean[] visited = new boolean[n];
        dfs(selected,visited, 0, n, m);
    }

    public static void dfs(int[] selected, boolean[] visited, int depth,int n, int m) {
        if (depth == m) {
            for(int i = 0; i <selected.length; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println("");
            return ;
        }
        for (int i = 1; i <= n; i++){
            if (!visited[i - 1]) {
                if (depth >= 1 && selected[depth - 1] > i)
                    continue;
                selected[depth] = i;
                visited[i - 1] = true;
                dfs(selected, visited, depth + 1, n, m);
                visited[i - 1] = false;
            }
        }
    }
}
