package BOJ;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Problem15651 {

    public static void run() throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] selected = new int[m];
        dfs(selected, 0, n, m, bufferedWriter);
        bufferedWriter.flush();
    }

    public static void dfs(int[] selected, int depth, int n, int m, BufferedWriter bw) throws Exception {
        if (depth == m) {
            for (int i = 0; i < selected.length; i++) {
                bw.write(selected[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            selected[depth] = i;
            dfs(selected, depth + 1, n, m, bw);
        }
    }
}
