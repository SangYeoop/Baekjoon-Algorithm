package BOJ;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] output = new int[3];
        perm(arr, output, 0, 3, 3);
    }

    static void perm(int[] arr, int[] output, int depth, int n, int r){
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(output[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = arr[i];
            perm(arr, output, depth + 1, n ,r);
        }
    }

}

