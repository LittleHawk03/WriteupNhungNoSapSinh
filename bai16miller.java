package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class bai16miller {
    static Scanner scanner = new Scanner(System.in);

    public static int random_number() {
        int min = 1, max = 100;
        return ThreadLocalRandom.current().nextInt(min,max + 1);
    }

    public static long square_loop(long a,long k,long n) {
        long b = 1;
        a = a % n;
        while (k > 0) {
            if (k % 2 == 1) {
                b = (b * a) % n;
            }
            k = k / 2;
            a = (a*a) % n;
        }
        return b;
    }

    public static Boolean millerRabin(int r,int n) {
        int min = 2,max = n -2;
        int a = (int) Math.floor(Math.random() * (max - min + 1) + min);
        int x = (int) square_loop(a, r, n);
        if (x == 1 || x == n -1) {
            return true;
        }
        while (r != n -1) {
            x = (x * x) % n;
            r = r * 2;

            if (x == 1) {
                return false;
            }
            if (x == n - 1){
                return true;
            }
        }
        return false;
    }

    public static Boolean isPrime(int n ,int k) {
        if (n <= 1 || n == 4) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        int r = n - 1;
        while (r % 2 == 0) {
            r = r / 2;
        }

        while (k > 0) {
            if (!millerRabin(r, n)) {
                return false;
            }
            k--;
        }
        return true;
    }

    // ham in mang
    public static void print_array(int[] a,int n) {
        System.out.print("[ ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int n, k = 5;
        System.out.println(" nhap n : ");
        n = scanner.nextInt();
        
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = random_number();
        }
        print_array(a, n);

        System.out.print(" cac so nguyen to trong mang la : [ ");
        // in ra cac so nguyen to trong mang
        for (int i = 0; i < n; i++) {
            if (isPrime(a[i], k)) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println("]");

    }
}

