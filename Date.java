package Buoi2_OOP;

import java.util.Scanner;

public class Date {
	private // Attribute
		int ngay, thang, nam;
	
	// Constructor
	public Date(){
		this.ngay = 1; this.thang = 1; this.nam = 1;
	}
	public Date(int day, int month, int year){
		this.ngay = day;
		this.thang = month;
		this.nam = year;
	}
	
	// Method
	public static Scanner sc = new Scanner(System.in);
	public boolean checkDay(){
		int max[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (this.nam % 400 == 0 || (this.nam % 4 == 0 && this.nam % 100 != 0))
				max[2] = 29;
		return (this.nam > 0 && this.thang > 0 && this.thang < 13 && this.ngay > 0 && this.ngay <= max[this.thang]);
	}
	public void readDay(){
		do{
			System.out.println("Nhap ngay/thang/nam:");
			this.ngay = sc.nextInt();
			this.thang = sc.nextInt();
			this.nam = sc. nextInt();
			if (!checkDay())
				System.out.println("Ngay khong hop le");
		}while (!checkDay());
	}
	public Date ngayHomSau(){
		Date d = new Date(this.ngay + 1, this.thang, this.nam);
		if(!d.checkDay()){
			d.ngay = 1;
			d.thang++;
			if (!checkDay()){
				d.thang = 1;
				d.nam++;
			}
		}
		return d;
	}
	public Date congNgay(int n){
		Date d = new Date(this.ngay, this.thang, this.nam);
		for (int i = 0; i < n; i++)
				d = d.ngayHomSau();
		return d;
	}
	public void hienThi(){
		System.out.println(String.format("%02d/%02d/%d", this.ngay, this.thang, this.nam));
	}
}
