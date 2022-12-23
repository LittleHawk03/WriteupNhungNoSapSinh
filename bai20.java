package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai20 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int m,n,d,a,b;
        System.out.println("nhap m : ");
        m = scanner.nextInt();
        System.out.println("nhap n : ");
        n = scanner.nextInt();
        System.out.println("nhap d : ");
        d = scanner.nextInt();

        if (d > n || d * 2 > n) {
            System.out.println("khong ton tai so do");
            return;
        }

        int l = n / d;

        for (int i = 2; i <= l; i++) {
            a = d;
            b = d * i;
            System.out.println("so a va b la : " + a +" , " + b);
        }

        for (int i = 2; i <= l; i++) {
            
            a = d * i;
            if (a >= m && a <= n) {
                
                for (int j = 1; j <= l; j++) {
                    b = d * j;
                    if (b < n && j % i != 0) {
                        System.out.println("so a va b la : " + a +" , " + b);
                    } 
                }
            }


        }
    }
}
