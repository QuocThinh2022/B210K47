package Buoi2_OOP;

import java.util.Scanner;
public class Diem {
	private // Attribute
		int x, y;
	// Constructor
	public Diem(){
		this.x = 0; this.y = 0;
	}
	public Diem(int x, int y){
		this.x = x; this.y = y;
	}
	
	// Method
	public static Scanner sc = new Scanner(System.in);
	public void nhapDiem(){
		System.out.print("Nhap x: "); this.x = sc.nextInt();
		System.out.print("Nhap y: "); this.y = sc.nextInt();
	}
	public void hienThi(){
		System.out.println(String.format("(%d, %d)", this.x, this.y));
	}
	public void doiDiem(int dx, int dy){
		this.x += dx;
		this.y += dy;
	}
	public int giaTriX(){
		return this.x;
	}
	public int giaTriY(){
		return this.y;
	}
	public float khoangCach(){
		return (float) Math.sqrt(this.x*this.x + this.y*this.y);
	}
	public float khoangCach(Diem d){
		return (float) Math.sqrt(Math.pow(this.x-d.x, 2) + Math.pow(this.y - d.y, 2));
	}
}
