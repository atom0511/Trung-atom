/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Train;
import java.util.Arrays;
import java.util.Scanner;

public class Train1 {

    public static void main(String[] args) {
        // Nhập vào STN và in ra số lớn nhất và xuất hiện nhiều nhất
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài mảng ");
        System.out.print("doDai1 = ");
        int doDai1 = sc.nextInt();

        int[] a = new int[doDai1];
        int[] b = new int[doDai1];
        System.out.println("Nhập các phần tử ");
        for (int i = 0; i < doDai1; i++) {
            String token = sc.next();
            a[i] = Integer.parseInt(token);
        }
        int[] c = a; // gán 1 mảng c giống a
        // sắp xếp lại mảng c từ bé đến lớn
        for (int i = 0; i < doDai1; i++) {
            for (int j = 0; j < doDai1; j++) {
                if (j > 0 && c[j] < c[j - 1]) {
                    int x = c[j];
                    c[j] = c[j - 1];
                    c[j - 1] = x;
                }
            }
        }
        // đếm số phần tử mảng a, dữ liệu đó lưu vào mảng b
        for (int i = 0; i < doDai1; i++) {
            for (int j = 0; j < doDai1; j++) {
                if (a[i] == a[j]) {
                    b[i]++;
                }
            }
        }
        // đọc ra số lặp nhiều nhất và lớn nhất
        int bMax = b[0];
        int cMax = c[0];
        for (int i = 0; i < doDai1; i++) {
            if (b[i] >= bMax && c[i] >= cMax ) {
                bMax = b[i];
                cMax = c[i];
            } 
        }
        System.out.println("Phần tử xuất hiện nhiều nhất và lớn nhất là " + cMax + " gồm " + bMax + " lần xuất hiện");  
    }
}
