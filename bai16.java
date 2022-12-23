package Security.WriteupNhungNoSapSinh;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class bai16 {
    

    static Scanner scanner = new Scanner(System.in);

    public static int random_number() {
        int min = 1, max = 100;
        return ThreadLocalRandom.current().nextInt(min,max + 1);
    }

    public static Boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        // nếu n ,à bằng 2 hay 3 thì nó là số nguyên tố lluoon
        if (n == 2 || n == 3) {
            return true;
        }
        // nếu n chia hết cho 2 thid nó là số chẵn -> loại 
        // nếu các số lẻ mà là bội của 3 như 9 , 15 -> loại 
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }

    // ham in mang
    public static void print_array(int[] a,int n) {
        System.out.print("[ ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int n;
        System.out.println(" nhap n : ");
        n = scanner.nextInt();
        
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = random_number();
        }
        print_array(a, n);

        System.out.print(" cac so nguyen to trong mang la : [ ");
        // in ra cac so nguyen to trong mang
        for (int i = 0; i < n; i++) {
            if (isPrime(a[i])) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println("]");

    }
}
