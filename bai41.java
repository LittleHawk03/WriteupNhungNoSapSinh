package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai41 {
    

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

    public static Boolean millerRabin(long r,long n) {
        long min = 2,max = n - 2;
        long a = (long) Math.round(Math.random() * (max - min + 1) + min);
        long x = (long) square_loop(a, r, n);
        if (x == 1 || x == n - 1) {
            return true;
        }
        while (r != n - 1) {
            x = (x * x) % n;
            r = r * 2;
            if (x == 1) {
                return false;
            }
            if(x == n - 1){
                return true;
            }
        }
        return false;
    }

    public static Boolean isPrime(long n ,long k) {
        if (n <= 1 || n == 4) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        long r = n - 1;
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
        System.out.println("nhap a : ");
        long a = scanner.nextInt();
        System.out.println("nhap k : ");
        long k = scanner.nextInt();
        System.out.println("nhap n : ");
        long n = scanner.nextInt();
        long x = (long) square_loop(a, k, n);
        System.out.println(a + " ^ " + k +" mod " + n + " = " + x);
        if (isPrime(x, 5)) {
            System.out.println("SO NGUYEN TO ");
        }else{
            System.out.println("KO PHAI SO NGUYEN TO");
        }
    }
}
