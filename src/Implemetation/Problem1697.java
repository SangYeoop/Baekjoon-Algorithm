package Implemetation;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem1697 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        boolean[] visit = new boolean[100001];

        int from = sc.nextInt();
        int to = sc.nextInt();

        LinkedList<Integer[]> queue = new LinkedList<>();
        Integer[] temp = new Integer[2];
        temp[0] = from;
        temp[1] = 0;

        queue.offer(temp);
        while (!queue.isEmpty()) {
            Integer[] a = queue.poll();
            visit[a[0]] = true;
            if (a[0] == to) {
                System.out.println(a[1]);
                break;
            }
            Integer[] b;
            if (a[0] + 1 <= 100000 && !visit[a[0] + 1]) {
                b = new Integer[2];
                b[0] = a[0] + 1;
                b[1] = a[1] + 1;
                queue.add(b);
            }
            if (a[0] - 1 >= 0 && !visit[a[0] - 1]) {
                b = new Integer[2];
                b[0] = a[0] - 1;
                b[1] = a[1] + 1;
                queue.add(b);
            }
            if (a[0] * 2 <= 100000 && !visit[a[0] * 2]) {
                b = new Integer[2];
                b[0] = a[0] * 2;
                b[1] = a[1] + 1;
                queue.add(b);
            }
        }
    }
}
