

import java.util.Scanner;

public class TinhLuong {
    String machucvu,manhanvien;
    int tonggio ;

    public TinhLuong() {
    }

    public TinhLuong(String manhanvien, String machucvu, int tonggio) {
        this.manhanvien = manhanvien;
        this.machucvu = machucvu;
        this.tonggio= tonggio;
    }
    
    public String getManhanvien() {
        return manhanvien;
    }
    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }
    
    public String getMachucvu() {
        return machucvu;
    }
    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }
    
    public int getTonggio() {
        return tonggio;
    }
    public void setTonggio(int tonggio) {
        this.tonggio = tonggio;
    }


    public String toString() {
        return "----LƯƠNG CỦA NHÂN VIÊN "+manhanvien + "----"+ "\n MÃ NHÂN VIÊN    " + manhanvien + "\n MÃ CHỨC VỤ      " + machucvu + "\n TỔNG GIỜ LÀM    "+tonggio+" tiếng"+"\n--------------------------------";
    }
    
    
    public void display() {
        System.out.println(this);
    }
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên (NVxx):");
        manhanvien = scan.nextLine();
        System.out.println("Nhập mã chức vụ (ql/pv/pc/bv/tn): ");
        machucvu= scan.nextLine();
        System.out.println("Nhập Tổng Số Giờ Làm Trong 1 Ngày: ");
        tonggio= sc.nextInt();
    }
}
