package Implemetation;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Problem2667 {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        char[][] arr = new char[num + 2][num + 2];
        boolean[][] searched = new boolean[num + 2][num + 2];

        Vector<Integer> result = new Vector<>();

        for (int i = 1; i <= num; i++) {
            String s = sc.next();
            for (int j = 1; j <= num; j++)
                arr[i][j] = s.charAt(j - 1);
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (arr[i][j] == '1' && !searched[i][j]) {
                    result.add(search(arr, searched, i, j));
                }
            }
        }
        System.out.println(result.size());
        result.sort(new Implemetation.Problem2667.OrderSort());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static int search(char[][] arr, boolean[][] searched, int i, int j) {
        int result = 0;
        if (searched[i][j])
            return 0;
        searched[i][j] = true;
        result++;
        if (arr[i + 1][j] == '1') {
            result += search(arr, searched, i + 1, j);
        }
        if (arr[i][j + 1] == '1') {
            result += search(arr, searched, i, j + 1);
        }
        if (arr[i - 1][j] == '1') {
            result += search(arr, searched, i - 1, j);
        }
        if (arr[i][j - 1] == '1') {
            result += search(arr, searched, i, j - 1);
        }
        return result;
    }

    static class OrderSort implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2)
                return 1;
            return -1;
        }
    }
}
