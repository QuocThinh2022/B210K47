package Buoi2_OOP;

import java.util.Collections;
import java.util.Scanner;

public class SDPhanSo {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		PhanSo a = new PhanSo(3, 7);
		PhanSo b = new PhanSo(4, 9);
		a.hienThi();
		b.hienThi();
		PhanSo x = new PhanSo();
		System.out.println("Nhap PhanSo x:");
		x.readFraction();
		PhanSo y = new PhanSo();
		System.out.println("Nhap PhanSo y:");
		y.readFraction();
		System.out.print("Gia tri nghich dao cua x: ");
		x.giaTriNghichDao().chuanHoa().hienThi();
		System.out.print("x + y = ");
		x.cong(y).hienThi();
		
		System.out.print("Nhap n: ");
		int n = sc.nextInt();
		PhanSo frac[] = new PhanSo[n];
		PhanSo fmax = new PhanSo(Integer.MIN_VALUE, 1), fsum = new PhanSo();
		for (int i = 0; i < n ; i++){
			frac[i] = new PhanSo();
			System.out.println("Nhap PhanSo thu " + (i+1));
			frac[i].readFraction();
			if (frac[i].lonHon(fmax))
					fmax = frac[i];
			fsum = fsum.cong(frac[i]).chuanHoa();
		}
		System.out.print("Tong = ");
		fsum.hienThi();
		System.out.print("fmax = ");
		fmax.chuanHoa().hienThi();
		System.out.println("Sort Fraction:");
		for (int i = 0; i < n; i++){
			for (int j = i+1; j < n; j++){
				if (frac[i].lonHon(frac[j])){
					PhanSo temp = new PhanSo();
					temp = frac[i];
					frac[i] = frac[j];
					frac[j] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++)
			frac[i].hienThi();
	}
}
