package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai34 {
    
    static Scanner scanner = new Scanner(System.in);

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

    public static Boolean fermat_cheking(int n,int k) {
        int min = 2,max = n - 2;
        if (n < 4) {
            return n == 2 || n == 3;
        }
        if (n % 2 == 0) {
            return false;
        }
        while (k > 0) {
            int a = (int) Math.floor(Math.random() * (max - min + 1) + min);
            System.out.println("a = " + a);
            long r = square_loop(a,  n - 1, n);
            if (r != 1) {
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
        if (fermat_cheking(n, k)) {
            System.out.println("SO NGUYEN TO");
        } else {
            System.out.println("HOP SO");
        }
    }
}
