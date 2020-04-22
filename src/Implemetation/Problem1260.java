package Implemetation;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem1260 {
    public static void run(){
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();

        int[][] arr = new int[node + 1][node + 1];
        boolean[] searched = new boolean[node + 1];

        for(int i = 0; i < edge; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        dfs(arr, searched, start, node);
        System.out.println();
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < node + 1; i++) {
            searched[i] = false;
        }
        queue.add(start);
        while(!queue.isEmpty()) {
            int a = queue.poll();
            bfs(queue, arr, searched, a, node);
        }
        System.out.println();
    }
    public static void dfs(int[][] arr, boolean[] searched, int start, int node) {
        if(searched[start])
            return;
        searched[start] = true;
        System.out.print(start + " ");
        for(int i = 1; i <= node; i++) {
            if (arr[start][i] == 1){
                dfs(arr, searched, i, node);
            }
        }
    }

    public static void bfs(LinkedList<Integer> queue, int [][] arr, boolean[] searched, int start, int node) {
        if(searched[start])
            return;
        searched[start] = true;
        System.out.print(start + " ");
        for(int i = 1; i <= node; i++) {
            if (arr[start][i] == 1)
                queue.add(i);
        }
    }
}
