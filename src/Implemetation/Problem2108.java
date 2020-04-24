package Implemetation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2108 {
    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            num += 4000;
            arr[num]++;
        }
        int maxIndex = 0;
        int maxValue = 0;
        boolean second = false;

        int max = 0;
        int min = 0;
        for (int i = 8000; i >= 0; i--) {
            if(arr[i] >= 1) {
                max = i;
                break;
            }
        }
        for (int i = 0; i <= 8000; i++) {
            if(arr[i] >= 1){
                min = i;
                break;
            }
        }
        int offset = Math.round((float)n / 2);
        int temp = 0;
        int middle = 0;
        boolean answer = false;
        for (int i = 0; i <= 8000; i++) {
            if(arr[i] > maxValue) {
                maxIndex = i;
                maxValue = arr[i];
                second = false;
            }else if(arr[i] == maxValue && !second) {
                maxIndex = i;
                second = true;
            }
            temp += arr[i];
            if (!answer && temp >= offset) {
                middle = i - 4000;
                answer = true;
            }
        }

        System.out.println(Math.round((float)sum / n));
        System.out.println(middle);
        System.out.println(maxIndex - 4000);
        System.out.println(max - min);
    }
}
