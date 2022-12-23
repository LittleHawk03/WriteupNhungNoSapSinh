package Security;

import java.util.Scanner;

public class bai21 {
    
    static Scanner scanner = new Scanner(System.in);

    public static Boolean solution(int N) {
        
        Boolean[] is_prime = new Boolean[N + 1];
        if (N >= 2) {
            is_prime[0] = false;
            is_prime[1] = false;
        }

        for (int j = 0; j < is_prime.length; j++) {
            is_prime[j] = true;
        }

        int count = 0;
        for (int i = 2; i*i <= N; i++) {
            if (is_prime[i]) {
                for (int j = i*i; j <= N; j+=i) {
                    is_prime[j] = false;
                }
            }
        }
        
        // System.out.print(" i : ");
        for (int i = 2; i < N; i++) {
            if (is_prime[i]) {
                // System.out.print(i + " ");
                count++;
            }
        }
        // System.out.println("cout : " + count);
        if (count >= 2 && is_prime[count]) {
            System.out.println("cout : " + count);
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int a,b;
        a = scanner.nextInt();
        b = scanner.nextInt();
        
        for (int i = a; i <= b; i++) {
            if (solution(i)) {
                System.out.print("so can tim la : ");
                System.out.print(i + " ");
                System.out.println("");
            }
        }
        // solution(7);
    }
}
