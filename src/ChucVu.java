import java.util.Scanner;

public class ChucVu {
    String machucvu,tenchucvu;
    int luongcoban ;

    public ChucVu() {
    }

    public ChucVu(String machucvu, String tenchucvu, int luongcoban) {
        this.machucvu = machucvu;
        this.tenchucvu = tenchucvu;
        this.luongcoban= luongcoban;
    }
    
    public String getMachucvu() {
        return machucvu;
    }
    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }
    
    public String getTenchucvu() {
        return tenchucvu;
    }   
    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    public int getLuongcoban() {
        return luongcoban;
    }
    public void setLuongcoban(int luongcoban) {
        this.luongcoban = luongcoban;
    }

    public String toString() {
        return "----------CHỨC VỤ---------" + "\n MÃ CHỨC VỤ    " + machucvu + "\n TÊN CHỨC VỤ   " + tenchucvu + "\n LƯƠNG CƠ BẢN  " + luongcoban+"\n--------------------------";
    }
    
    public void display() {
        System.out.println(this);
    }
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập mã chức vụ: ");
        machucvu = scan.nextLine();
        System.out.println("Nhập tên chức vụ: ");
        tenchucvu= scan.nextLine();
        System.out.println("Nhập tiền lương cơ bản: ");
        luongcoban= scan.nextInt();
    }
}
