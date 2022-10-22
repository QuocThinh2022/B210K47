package Buoi2_OOP;

import java.util.Scanner;

public class SSDate {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Date d = new Date();
		d.hienThi();
		d.readDay();
		d.hienThi();
		d.ngayHomSau().hienThi();;
		System.out.println("Nhap n: ");
		int n = sc.nextInt();
		d.congNgay(n).hienThi();
	}
}
