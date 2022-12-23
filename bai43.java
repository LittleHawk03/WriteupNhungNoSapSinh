package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class bai43 {
    static Scanner scanner = new Scanner(System.in);
    static int[] list_frime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
        31, 37, 41, 43, 47, 53, 59, 61, 67,
        71, 73, 79, 83, 89, 97};

    public static int randomN() {
        int min = 2, max = 100;
        return ThreadLocalRandom.current().nextInt(min,max + 1);
    }

    public static int getLowLevelPrime() {
        while (true) {
            int pc = randomN();
            for (int i : list_frime) {
                if (pc % i == 0 && i*i <= pc) {
                    break;
                }else{
                    return pc;
                }
            }
        }
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
        int min = 2, max = n - 2;
        int a = (int) Math.floor(Math.random() * (max - min + 1) + min);
        int x = (int) square_loop(a, r, n);
        if (x == 1 || x == n - 1) {
            return true;
        }
        while (r != n - 1) {
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

    public static int random_search() {
        while (true) {
            int prime_number = getLowLevelPrime();
            if (!isPrime(prime_number, 10)) {
                continue;
            }else{
                return prime_number;
            }
        }
    }


    public static void main(String[] args) {
        int N,p;
        N = scanner.nextInt();
        p = random_search();
        System.out.println("sinh so nguyen to P : " + p);
        for (int i = 2; i <= N; i++) {
            int x = (int) square_loop(i, p, N);
            if (isPrime(x, 5)) {
                System.out.println("i : " + i + " power = " + x);
            }
        }
    }
}
