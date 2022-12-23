package Security;

import java.util.Arrays;
import java.util.Scanner;

public class bai27 {
    
    static Boolean[] isPrime = new Boolean[1000 + 1];
    static Scanner scanner = new Scanner(System.in);

    public static void Eratosthenes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i*i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= 1000; j+= i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    
    public static int gcd(int a,int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        Eratosthenes();
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = a; i <= b; i++) {
            for (int j = a; j <= b; j++) {
                int uc = gcd(i, j);
                if (isPrime[uc]) {
                    System.out.println("the (a, b) : (" + i +" , " + j + ")  : gcd = " + uc);
                }
            }
        }
    }   
}
