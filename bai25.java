package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai25 {

    static Scanner scanner = new Scanner(System.in);

    public static int[] sang(int n) {
        Boolean[] isPrime = new Boolean[n + 1];
        // gan gia tri cua tat ca phan tu cua mang la true
        for (int i = 0; i < n + 1; i++) {
            isPrime[i] = true;
        }

        // tien hanh sang so nguyen to
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // dãy này để lưu các số nguyên tố

        int size = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                size++;
            }
        }

        int[] arr = new int[size];
        int j = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                arr[j] = i;
                j++;
            }
        }

        return arr;
    }

    public static void subset(int[] A, int k, int M, int start, int currLen, boolean[] used) {

        if (currLen == k) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                if (used[i] == true) {
                    sum += A[i];
                }
            }
            if (sum == M) {
                System.out.print("[");
                for (int i = 0; i < A.length; i++) {
                    if (used[i] == true) {
                        System.out.print(A[i] + " ");
                    }
                }
                System.out.println("]");
            }
            return;
        }
        if (start == A.length) {
            return;
        }
        // For every index we have two options,
        // 1.. Either we select it, means put true in used[] and make currLen+1
        used[start] = true;
        subset(A, k, M, start + 1, currLen + 1, used);
        // 2.. OR we dont select it, means put false in used[] and dont increase
        // currLen
        used[start] = false;
        subset(A, k, M, start + 1, currLen, used);
    }

    public static void main(String[] args) {
        int M, N;
        System.out.println("nhap M : ");
        M = scanner.nextInt();
        System.out.println("nhap N :");
        N = scanner.nextInt();
        int[] a = sang(M);
        boolean[] B = new boolean[a.length];
        subset(a, N, M, 0, 0, B);
    }
}
