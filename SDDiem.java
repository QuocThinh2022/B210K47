package Buoi2_OOP;

public class SDDiem {
	public static void main(String[] args) {
		Diem A = new Diem(3, 4);
		A.hienThi();
		
		Diem B = new Diem();
		B.nhapDiem();
		B.hienThi();
		
		Diem C = new Diem(-B.giaTriX(), -B.giaTriY());
		C.hienThi();
		
		System.out.println("Khoang cach OB = " + B.khoangCach());
		
		System.out.println("Khoang cach AB = " + A.khoangCach(B));
	}
}
