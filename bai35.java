package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai35 {

    static Scanner scanner = new Scanner(System.in);
    
    public static long square_loop(long a,long k,long n) {
        long b = 1;
        a = a % n;
        while (k > 0) {
            if (k % 2 == 1) {
                b = (b * a) % n;
            }
            k = k >> 1;
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

    public static void main(String[] args) {
        System.out.println("nhap n : ");
        int n = scanner.nextInt();
        System.out.println("nhap k : ");
        int k = scanner.nextInt();

        if (isPrime(n, k)) {
            System.out.println("SO NGUYEN TO");
        }else{
            System.out.println("HOP SO");
        }
    }
}
