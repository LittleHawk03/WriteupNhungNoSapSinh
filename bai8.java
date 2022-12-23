package Security;

import java.util.Arrays;
import java.util.Scanner;

public class bai8 {
    
    static Scanner scanner = new Scanner(System.in);

    public static Boolean TprimeCheck(int n) {
        Boolean[] isPrime = new Boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j+= i) {
                    isPrime[j] = false;
                }
            }
        }
        /*
         * so luong cac uoc so cua mot so sẽ tuân 
         * theo công thức sl = (a + 1)*(b + 1)*(c + 1)*.....
         * với a,b,c ...  là số mũ của các số nguyên tố 
         * trong phép phân tích 
         * 
         * vd = 20 = 2^2 x 5 (a = 2 , b = 1)
         * thi sẽ có (2 + 1)*(1 + 1) = 6 ược : 1 2 4 5 10 20
        */

        int soLuong = 1;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                int dem = 0;
                if (n % i == 0) {
                    while (n % i == 0) {
                        n = n / i;
                        dem++;
                    }
                }
                soLuong = soLuong * (dem + 1);
            }
        }
        return soLuong == 3;
    }

    public static void main(String[] args) {
        int N;
        System.out.println(" nhap N : ");
        N = scanner.nextInt();
        for (int i = 2; i < N; i++) {
            if (TprimeCheck(i)) {
                System.out.println("i = " + i);
            }
        }
    }
}
