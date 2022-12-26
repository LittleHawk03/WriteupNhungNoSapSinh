package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai6 {
    static Scanner scanner = new Scanner(System.in);

    /**
     * tong các ước số 
     * vd 18 có 2 ước là 2 và 9 thi mình chỉ cần sét là tổng là 2 + (18 / 2)
    */
    public static long tongCacSoUocSo(long n) {
        long sum = 1;
        for (long i = 2; i*i < n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    sum += i;
                }else{
                    sum += (i + (n / i));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        long n;
        System.out.println("nhap N : ");
        n = scanner.nextLong();
        for (long i = 1; i <= n; i++) {
            long a = tongCacSoUocSo(i);
            if (i == tongCacSoUocSo(a) && a != i && a < n && i < a) {
                System.out.println(i + " " + a);
            }
        }
    }
}
