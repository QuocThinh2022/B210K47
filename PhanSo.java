package Buoi2_OOP;

import java.util.Scanner;

public class PhanSo {
	private
		int tu, mau;
	// Constructor
	public PhanSo(){
		this.tu = 0;
		this.mau = 1;
	}
	public PhanSo(int tu, int mau){
		this.tu = tu;
		this.mau = mau;
	}
	
	// Method
	public Scanner sc = new Scanner(System.in);
	public void readFraction(){
		do{
			System.out.println("Nhap tu, mau: ");
			this.tu = sc.nextInt();
			this.mau = sc.nextInt();
			if (this.mau == 0)	
				System.out.println("mau phai khac 0");
		}while (this.mau == 0);
	}
	public void hienThi(){
		if (this.tu == 0 || this.mau == 1)
			System.out.println(this.tu);
		else{
			if (this.mau < 0){
				this.tu *= -1;
				this.mau *= -1;
			}
				
			System.out.println(this.tu + "/" + this.mau);
		}
	}
	public void nghicDao(){
		int temp = this.tu;
		this.tu = this.mau;
		this.mau = temp;
	}
	public PhanSo giaTriNghichDao(){
		PhanSo frac = new PhanSo(this.tu, this.mau);
		int temp = frac.tu;
		frac.tu = frac.mau;
		frac.mau = temp;
		return frac;
	}
	public float giaTriThuc(PhanSo a){
		return (float) this.tu/this.mau;
	}
	public boolean lonHon(PhanSo a){
		return (this.tu*a.mau > a.tu*this.mau);
	}
	public int GCD(){
		int a = Math.abs(this.tu);
		int b = Math.abs(this.mau);
		int r;
		while (b != 0){
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	public PhanSo chuanHoa(){
		PhanSo ans = new PhanSo(this.tu, this.mau);
		int gcd = ans.GCD();
		if (ans.mau < 0){
			ans.tu *= -1;
			ans.mau *= -1;
		}
		ans.tu /= gcd;
		ans.mau /= gcd;
		return ans;
	}
	
	public PhanSo cong(PhanSo a){
		PhanSo ans = new PhanSo(this.tu, this.mau);
		ans.tu = ans.tu*a.mau + a.tu*ans.mau;
		ans.mau *= a.mau;
		return ans.chuanHoa();
	}
	
	public PhanSo tru(PhanSo a){
		PhanSo ans = new PhanSo(this.tu, this.mau);
		ans.tu = ans.tu*a.mau - a.tu*ans.mau;
		ans.mau *= a.mau;
		return ans.chuanHoa();
	}
	public PhanSo nhan(PhanSo a){
		PhanSo ans = new PhanSo(this.tu, this.mau);
		ans.tu *= a.tu;
		ans.mau *= ans.mau;
		return ans.chuanHoa();
	}
	public PhanSo chia(PhanSo a){
		PhanSo ans = new PhanSo(this.tu, this.mau);
		return ans.nhan(ans.giaTriNghichDao()).chuanHoa();
	}
	
	public PhanSo cong(int a){
		PhanSo ans = new PhanSo(this.tu, this.mau);
		ans.tu += ans.mau * a;
		return ans.chuanHoa();
	}
	
	public PhanSo tru(int a){
		PhanSo ans = new PhanSo(this.tu, this.mau);
		ans.tu -= ans.mau * a;
		return ans.chuanHoa();
	}
	public PhanSo nhan(int a){
		PhanSo ans = new PhanSo(this.tu*a, this.mau);
		return ans.chuanHoa();
	}
	public PhanSo chia(int a){
		PhanSo ans = new PhanSo(this.tu/a, this.mau);
		return ans.chuanHoa();
	}
}
