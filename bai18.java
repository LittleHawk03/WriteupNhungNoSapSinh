package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai18 {

    static Scanner scanner = new Scanner(System.in);
    static int p = 2147483647;
    static long W = 8;
    static int m = (int) Math.round(Math.log(p) / Math.log(2));
    static int t = (int) Math.round((double) m / W);
    static int e = 0;

    /**
     * ham chuyen mot so nguyen thanh mot mang 
     * kỹ thuật như sau để chuyển một số về cá byte gồm 
     * 8 bit nhưng thôi nói nó phức tạp lăm đọc slide
     * ở đây vi dụ mình chuyển số 38762497
     * để lấy n bit cuối cùng của môt số ta chỉ cần chia nó cho 2 ^ n (ở đây mình 2 ^ 8)
     * 1.  a[3] = 38762497 % 2 ^ 8 = 1  -> só n = n / x ^ 8 = 151416 
     * 2.  a[2] = 151416 % 2 ^ 8 = 120  -> só n = n / x ^ 8 = 591
     * 3.  a[1] = 591 % 2 ^ 8 = 79  -> só n = n / x ^ 8 = 2
     * 4.  a[0] = 2 % 2 ^ 8 = 2  -> só n = n / x ^ 8 = 0
     * => 38762497 = [2 ,79 , 120 , 1]
    */
    public static int[] Interger_to_array(int n) {
        int[] arr = new int[t];
        int x;
        int pow = (int) Math.pow(2, W);

        for (int i = 0; i < t; i++) {
            x = n % pow;
            n = n / pow;
            arr[t - i - 1] = x;
        }

        return arr;
    }

    /*
     * tiến hành trừ : xem slide để hiểu hơn lưu ý mảng bị xoay ngược
     * ví dụ : [1 ,2 ,3 ,4 ] nhưng khi tính toán thi mảng sẽ là [4,3,2,1] 
    */
    public static int[] Multiprecision_addition(int[] a, int[] b) {
        int[] c = new int[(int) t];
        int pow = (int) Math.pow(2, 8);
        for (int i = 0; i < t; i++) {
            int x = a[t - i - 1] + b[t - i - 1] + e;
            int s = x % pow;

            if (x > pow) {
                e = 1;
            } else {
                e = 0;
            }
            c[t - i - 1] = s;
        }

        return c;
    }

    /**
     * hàm nhập một mảng từ bàn phím 
    */
    public static void scannerArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
    }

    /*
     * hàm in một mảng 
    */
    public static void print_array(int[] arr) {
        System.out.print("("+e+",[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("])");
    }

    public static void main(String[] args) {
        System.out.println("1 : cong hai day so");
        System.out.println("2 : cong hai so nguyen sieu lon");
        int option = scanner.nextInt();
        if (option == 1) {
            int[] a = new int[4];
            int[] b = new int[4];
            System.out.println("nhap mang a : ");
            scannerArray(a);
            System.out.println("nhap mang b : ");
            scannerArray(b);
            print_array(Multiprecision_addition(a, b));
        }else{
            System.out.println("nhap so nguyen a : ");
            int[] a = Interger_to_array(scanner.nextInt());
            System.out.println("nhap so nguyen b : ");
            int[] b = Interger_to_array(scanner.nextInt());
            print_array(Multiprecision_addition(a, b));
        }
    }
}
