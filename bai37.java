package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai37 {
    
    static Scanner scanner = new Scanner(System.in);

    public static int[] failure_funtion(String P) {
        int l = P.length();
        int i = 0,j = 1;
        int[] arr = new int[l];
        for (int k = 0; k < arr.length; k++) {
            arr[k] = 0;
        }
        while (j < l) {
            if (P.charAt(i) == P.charAt(j)) {
                arr[j] = i + 1;
                i++;
                j++;
            }else{
                if (i == 0) {
                    arr[j] = 0;
                    j++;
                }else{
                    i = arr[i - 1];
                }
            }
        }
        return arr;
    }

    public static Boolean KMP(String T,String P) {
        int[] L = failure_funtion(P);
        int m = P.length();
        int n = T.length();
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < n) {
            count++;
            if (P.charAt(j) == T.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println("count = " + count +" i - j = " + (i - j));
                return true;
            }else if (i < n && P.charAt(j) != T.charAt(i)) {
                if (j != 0) {
                    j = L[j - 1];
                }else{
                    i++;
                }
            }

        }

        System.out.println("count = " + count +" i - j = " + (i - j));
        return false;
    }

    public static void main(String[] args) {
        System.out.println("nhap day  T : ");
        String T = scanner.nextLine();
        System.out.println("nhap P :");
        String P = scanner.nextLine();

        if (KMP(T, P)) {
            System.out.println("T include P");
        }else{
            System.out.println("T not include P");
        }
    }
}
