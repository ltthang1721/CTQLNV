

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.Scanner;

public class NhanVien {
    String manhanvien, hoten, gioitinh, diachi, SDT, email, machucvu;

    public NhanVien() {
    }

    public NhanVien(String manhanvien, String hoten, String gioitinh, String diachi, String SDT, String email, String machucvu) {
        this.manhanvien = manhanvien;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.SDT = SDT;
        this.email = email;
        this.machucvu = machucvu;
        
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    
    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
     public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
     public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }
     
    @Override
    public String toString() {
        return "--------------------NHÂN VIÊN--------------------" + "\n MÃ NHÂN VIÊN    " + manhanvien + "\n MÃ CHỨC VỤ      " + hoten + "\n GIỚI TÍNH       " + gioitinh + "\n ĐỊA CHỈ         " + diachi + "\n SỐ ĐIỆN THOẠI   " + SDT + "\n EMAIL           " + email+ "\n MÃ CHỨC VỤ      " + machucvu +"\n-------------------------------------------------";
    }
    
    public void display() {
        System.out.println(this);
    }
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Mã Nhân Viên (NVxx):");
        manhanvien = scan.nextLine();
        System.out.println("Nhập Họ & Tên Nhân Viên:");
        hoten = scan.nextLine();
        System.out.println("Nhập Giới Tính Nhân Viên (Nam/Nữ):");
        gioitinh = scan.nextLine();
        System.out.println("Nhập Địa Chỉ Nhân Viên:");
        diachi = scan.nextLine();
        System.out.println("Nhập Số Điện Thoại Nhân Viên:");
        SDT = scan.nextLine();
        System.out.println("Nhập Email Nhân Viên:");
        email = scan.nextLine();
        System.out.println("Nhập Mã Chức Vụ(ql/pv/pc/bv/tn):");
        machucvu = scan.nextLine();

       
    }
}
