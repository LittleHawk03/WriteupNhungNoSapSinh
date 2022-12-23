package Security;

import java.util.Arrays;
import java.util.Scanner;

public class bai26 {

    static Scanner scanner = new Scanner(System.in);
    
    public static Boolean solution(int a) {
        Boolean[] isPrime = new Boolean[a + 1];
        Arrays.fill(isPrime,true);
        for (int i = 2; i <= (int) Math.sqrt(a); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= a; j += i) {
                    isPrime[j] = false;
                }                
            }
        }
        for (int i = 2; i <= a; i++) {
            if (isPrime[i]) {
               if (a % i == 0 && a % (i*i) == 0) {
                    return true;
               }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a = scanner.nextInt();
        for (int i = 2; i <= a; i++) {
            if (solution(i)) {
                System.out.println(i);
            }
        }
    }
}
