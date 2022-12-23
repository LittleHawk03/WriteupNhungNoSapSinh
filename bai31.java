package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai31 {

    static Scanner scanner = new Scanner(System.in);

    public static long power(long a,long k,long n) {
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

    public static Boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;

    }

    public static int nearPrime(int n) {
        int pnear = 0, snear;
        for (int i = n - 1; i >= 1; i--) {
            if (isPrime(i)) {
                pnear = i;
                break;
            }
        }
        if (isPrime(n)) {
            return pnear;
        }
        snear = pnear + 1;
        for (int i = n; i < n + pnear; i++) {
            if (isPrime(i)) {
                snear = i;
                break;
            }
        }
       
        if ((n - pnear) > (snear - n)) {
            return snear;
        }else if ((n - pnear) == (snear - n)) {
            return pnear;
        }else {
            return pnear;
        }
    }

    public static void main(String[] args) {
        int maSV,SBD;
        int n = 123456;
        System.out.println("ma SV :");
        maSV = scanner.nextInt();
        System.out.println("sbd : ");
        SBD = scanner.nextInt();
        int k = nearPrime(maSV);
        System.out.println(k);
        System.out.println(power(SBD, k, n));
    }
}
