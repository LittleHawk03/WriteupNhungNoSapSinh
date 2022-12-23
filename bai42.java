package Security.WriteupNhungNoSapSinh;

import java.util.concurrent.ThreadLocalRandom;

public class bai42 {
    
    static int[] list_frime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
        31, 37, 41, 43, 47, 53, 59, 61, 67,
        71, 73, 79, 83, 89, 97, 101, 103,
        107, 109, 113, 127, 131, 137, 139,
        149, 151, 157, 163, 167, 173, 179,
        181, 191, 193, 197, 199, 211, 223,
        227, 229, 233, 239, 241, 251, 257,
        263, 269, 271, 277, 281, 283, 293,
        307, 311, 313, 317, 331, 337, 347, 349};

    public static int randomN() {
        int min = 2, max = 1000;
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
        int p , q;
        p = random_search();
        q = random_search();
        System.out.println("p = " + p);
        System.out.println("q = " + q);
        for (int i = 1; i <= 100; i++) {
            int x = (int) square_loop(i, p, q);
            if (isPrime(x, 5)) {
                System.out.println("i  : " + i + " x : " + x);
            }
        }

       
    }

}
