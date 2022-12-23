package Security;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class bai45 {
    
    static int[] list_frime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
        31, 37, 41, 43, 47, 53, 59, 61, 67,
        71, 73, 79, 83, 89, 97, 101, 103,
        107, 109, 113, 127, 131, 137, 139,
        149, 151, 157, 163, 167, 173, 179,
        181, 191, 193, 197, 199, 211, 223,
        227, 229, 233, 239, 241, 251, 257,
        263, 269, 271, 277, 281, 283, 293,
        307, 311, 313, 317, 331, 337, 347, 349};

    static Scanner scanner = new Scanner(System.in);

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

    public static void printArray(int[] arr,int n) {
        System.out.print("[ ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ]");
    }

    public static void MinDistane(int[] arr, int N) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i + 1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
            }
        }  
        System.out.println("min : " + min);
    }

    public static void main(String[] args) {
        int N;
        System.out.println("nhap kich thuoc mang : ");
        N = scanner.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = random_search();
        }
        printArray(arr, N);
        MinDistane(arr, N);

    }
}
