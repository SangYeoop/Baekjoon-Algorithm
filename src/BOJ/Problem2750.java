package BOJ;

import java.util.Scanner;

public class Problem2750 {
    public static void run(){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] arr = new int[num];

        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < num - 1; i++)
            for(int j = i; j < num; j++){
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        for(int i = 0; i < num; i++)
            System.out.println(arr[i]);
    }
}
