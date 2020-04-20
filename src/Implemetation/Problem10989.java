package Implemetation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10989 {
    public static void run() throws Exception{
        int[] arr = new int[10001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[a]++;
        }


        for(int i = 1; i < 10001; i++){
            for(int j= 0; j < arr[i]; j++){
                bf.write(i + "\n");
            }
        }
        bf.flush();
    }
}
