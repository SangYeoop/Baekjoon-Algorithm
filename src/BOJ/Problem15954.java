package BOJ;

import java.io.*;
import java.util.List;
import java.util.Vector;

public class Problem15954 {
    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Vector<Integer> arr = new Vector<>(n);
        int[] prefixSum = new int[n + 1];
        s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr.add(Integer.parseInt(s[i - 1]));
            prefixSum[i] = prefixSum[i - 1] + arr.get(i - 1);
        }

        double min = Double.MAX_VALUE;
        for (; m <= n; m++) {
            for (int i = 0; i <= n - m; i++) {
                double result = calculate(arr.subList(i, i + m), prefixSum[i + m] - prefixSum[i]);
                if (min > result)
                    min = result;
            }
        }
        double a = Math.sqrt(min);
        wr.write(a + "\n");
        br.close();
        wr.close();
    }

    public static double calculate(List<Integer> arr, double sum){
        int size = arr.size();
        double m = sum / size;

        double dSum = 0;
        for(int i = 0; i < size; i++) {
            double temp = arr.get(i) - m;
            dSum += temp * temp;
        }
        return dSum / size;
    }
}
