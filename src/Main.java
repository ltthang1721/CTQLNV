import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
            int option1, option2 = 1;
            do {
                showMenu();
                option1 = Integer.parseInt(scan.nextLine());

                switch (option1) {
                    case 1:
                        showNV();
                        break;
                    case 2:
                        addNV();
                        break;
                    case 3:
                        updateNV();
                        break;
                    case 4:
                        deleteNV();
                        break;
                    case 5:
                        showCV();
                        break;
                    case 6:
                        addCV();
                        break;
                    case 7:
                        updateCV();
                        break;
                    case 8:
                        deleteCV();
                        break;
                    case 9:
                        salary();
                        break;
                    case 10:
                        update_tonggio();
                        break;
                    case 11:
                        search_info();
                        break;
                    case 12:
                        searchCV();
                        break;
                    case 13:
                        search_tonggio();
                        break;
                    case 14:
                        searchGT();
                        break;
                    default:
                        System.out.println("ĐÃ THOÁT KHỎI CHƯƠNG TRÌNH!");
                        break;
                }
                System.out.println("BẠN CÓ MUỐN THỰC HIỆN CÔNG VIỆC KHÁC? (1. Tiếp Tục, 2. Kết Thúc)");
                option2 = input.nextInt();
            } while (option2 == 1);
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    static void showMenu() {
        System.out.println("YÊU CẦU CỦA BẠN: ");
        System.out.println("\t1. Hiển Thị Danh Sách Nhân Viên");
        System.out.println("\t2. Thêm Nhân Viên");
        System.out.println("\t3. Sửa Thông Tin Nhân Viên");
        System.out.println("\t4. Xóa Nhân Viên");
        System.out.println("\t5. Hiển Thị Danh Sách Chức Vụ");
        System.out.println("\t6. Thêm Chức Vụ");
        System.out.println("\t7. Sửa Thông Tin Chức Vụ");
        System.out.println("\t8. Xóa Chức Vụ");
        System.out.println("\t9. Xem Bảng Tính Lương");
        System.out.println("\t10. Cập Nhật Tổng Số Giờ Làm Của Nhân Viên");
        System.out.println("\t11. Tìm Kiếm Nhân Viên Theo Tên");
        System.out.println("\t12. Tìm Kiếm Chức Vụ");
        System.out.println("\t13. Tìm Kiếm Tổng Giờ Làm Một Ngày Của Một Nhân Viên Cụ Thể");
        System.out.println("\t14. Lọc Nhân Viên Theo Giới Tính");
        System.out.println("\t0. Thoát Khỏi Chương Trình!");
        System.out.println("BẠN MUỐN THỰC HIỆN CÔNG VIỆC GÌ? (Vui lòng nhập số tương ứng)");
    }

    public static void showNV() throws SQLException {
        Statement statement = null;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
        String sql = "SELECT * FROM nhanvien nv " + "INNER JOIN chucvu cv ON nv.machucvu = cv.machucvu";
        statement = conn.createStatement();
        java.sql.ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("DANH SÁCH NHÂN VIÊN");
        System.out.print("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
        System.out.print("|Mã Nhân Viên|        Họ & Tên      | Giới Tính |                        Địa Chỉ                     |Số Điện Thoại|                Email                |  Chức Vụ  |\n");
        System.out.print("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
        while (resultSet.next()) {
            System.out.format("|%8s    | ", resultSet.getString("manhanvien"));
            System.out.format("%20s | ", resultSet.getString("hoten"));
            System.out.format("%10s| ", resultSet.getString("gioitinh"));
            System.out.format("%50s | ", resultSet.getString("diachi"));
            System.out.format("%11s | ", resultSet.getString("SDT"));
            System.out.format("%35s | ", resultSet.getString("email"));
            System.out.format("%8s  | \n", resultSet.getString("tenchucvu"));
            System.out.print("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
        }
    }

    public static void showCV() throws SQLException {
        Statement statement = null;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
        String sql = "SELECT * FROM chucvu ";
        statement = conn.createStatement();
        java.sql.ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("\tDANH SÁCH CHỨC VỤ");
        System.out.print("|-----------------------------------|\n");
        System.out.print("|Mã Chức Vụ|Tên Chức Vụ|Lương Cơ Bản|\n");
        System.out.print("|-----------------------------------|\n");
        while (resultSet.next()) {
            System.out.format("|%6s    | ", resultSet.getString("machucvu"));
            System.out.format("%8s  | ", resultSet.getString("tenchucvu"));
            System.out.format("%6dVNĐ  | \n", resultSet.getInt("luongcoban"));
            System.out.print("|-----------------------------------|\n");
        }
    }

    public static void salary() throws SQLException {
        Statement statement = null;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
        String sql = "SELECT * FROM tinhluong tl " + "INNER JOIN chucvu cv ON tl.machucvu = cv.machucvu";
        statement = conn.createStatement();
        java.sql.ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("BẢNG LƯƠNG NHÂN VIÊN THEO NGÀY:\n");
        System.out.print("|----------------------------------------------------------------------------|\n");
        System.out.print("|Mã Nhân Viên|Mã Chức Vụ|Tổng Giờ Làm|Lương Cơ Bản|   Tiền Lương Theo Ngày   |\n");
        System.out.print("|----------------------------------------------------------------------------|\n");
        while (resultSet.next()) {
            System.out.format("|%8s    | ", resultSet.getString("manhanvien"));
            System.out.format("%6s   | ", resultSet.getString("machucvu"));
            System.out.format("%3d tiếng  | ", resultSet.getInt("tonggio"));
            System.out.format("%6dVNĐ  | ", resultSet.getInt("luongcoban"));
            System.out.format("%2d * %2d =%8dVNĐ  |\n", resultSet.getInt("tonggio"), resultSet.getInt("luongcoban"), resultSet.getInt("tonggio") * resultSet.getInt("luongcoban"));
            System.out.print("|----------------------------------------------------------------------------|\n");
        }
    }

    public static void addNV() throws SQLException {
        System.out.println("THÊM NHÂN VIÊN:\n");
        NhanVien nhanvien = new NhanVien();
        nhanvien.input();
        PreparedStatement stm = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "insert into nhanvien(manhanvien, hoten, gioitinh, diachi, SDT, email, machucvu)values(?,?,?,?,?,?,?)";
            stm = conn.prepareCall(sql);
            stm.setString(1, nhanvien.getManhanvien());
            stm.setString(2, nhanvien.getHoten());
            stm.setString(3, nhanvien.getGioitinh());
            stm.setString(4, nhanvien.getDiachi());
            stm.setString(5, nhanvien.getSDT());
            stm.setString(6, nhanvien.getEmail());
            stm.setString(7, nhanvien.getMachucvu());

            stm.execute();
            System.out.println("ĐÃ THÊM NHÂN VIÊN!");
        } catch (SQLException ex) {
            System.out.println("Thêm Thất Bại! Lỗi: " + ex.getMessage());
        }
    }

    public static void addCV() throws SQLException {
        System.out.println("THÊM CHỨC VỤ:");
        ChucVu chucvu = new ChucVu();
        chucvu.input();
        PreparedStatement stm = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "insert into chucvu(machucvu,tenchucvu,luongcoban)values(?,?,?)";
            stm = conn.prepareCall(sql);
            stm.setString(1, chucvu.getMachucvu());
            stm.setString(2, chucvu.getTenchucvu());
            stm.setInt(3, chucvu.getLuongcoban());

            stm.execute();
            System.out.println("ĐÃ THÊM CHỨC VỤ!");
        } catch (SQLException ex) {
            System.out.println("Thêm Thất Bại! Lỗi: " + ex.getMessage());
        }
    }

    public static void deleteNV() {
        System.out.println("NHẬP MÃ NHÂN VIÊN MUỐN XÓA: ");
        String manhanvien = scan.nextLine();
        PreparedStatement statement = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "delete from nhanvien where manhanvien = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, manhanvien);
            statement.execute();
            System.out.println("ĐÃ XÓA NHÂN VIÊN!");
        } catch (SQLException ex) {
            System.out.println("Xóa Thất Bại! Lỗi: " + ex.getMessage());
        }
    }

    public static void deleteCV() {
        System.out.println("NHẬP CHỨC VỤ MUỐN XÓA: ");
        String machucvu = scan.nextLine();
        PreparedStatement statement = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "delete from chucvu where machucvu = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, machucvu);
            statement.execute();
            System.out.println("ĐÃ XÓA CHỨC VỤ!");
        } catch (SQLException ex) {
            System.out.println("Xóa Thất Bại! Lỗi: " + ex.getMessage());
        }
    }

    public static void updateNV() {
        System.out.println("SỬA THÔNG TIN NHÂN VIÊN THEO MÃ NHÂN VIÊN:");
        NhanVien nhanvien = new NhanVien();
        nhanvien.input();
        PreparedStatement statement = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "update nhanvien set hoten = ?, gioitinh = ?,diachi = ?, SDT = ?, email = ?, machucvu = ?" + "where manhanvien = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, nhanvien.getHoten());
            statement.setString(2, nhanvien.getGioitinh());
            statement.setString(3, nhanvien.getDiachi());
            statement.setString(4, nhanvien.getSDT());
            statement.setString(5, nhanvien.getEmail());
            statement.setString(6, nhanvien.getMachucvu());
            statement.setString(7, nhanvien.getManhanvien());
            statement.execute();
            System.out.println("ĐÃ SỬA THÔNG TIN NHÂN VIÊN!");
        } catch (SQLException ex) {
            System.out.println("Sửa Thất Bại! Lỗi: " + ex.getMessage());
        }
    }

    public static void update_tonggio() {
        System.out.println("CẬP NHẬT TỔNG SỐ GIỜ LÀM CỦA NHÂN VIÊN THEO NGÀY: ");
        TinhLuong tinhluong = new TinhLuong();
        Connection conn = null;
        tinhluong.input();
        PreparedStatement s = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "update tinhluong set machucvu = ? , tonggio = ?" + " where manhanvien = ? ";
            s = conn.prepareCall(sql);

            s.setString(1, tinhluong.getMachucvu());
            s.setInt(2, tinhluong.getTonggio());
            s.setString(3, tinhluong.getManhanvien());

            s.execute();
            System.out.println("ĐÃ CẬP NHẬT TỔNG GIỜ LÀM CỦA NHÂN VIÊN!");
        } catch (SQLException ex) {
            System.out.println("Cập Nhật Thất Bại! Lỗi: " + ex.getMessage());
        }

    }

    public static void updateCV() {
        System.out.println("CHỈNH SỬA CHỨC VỤ:");
        ChucVu chucvu = new ChucVu();
        Connection conn = null;
        chucvu.input();
        PreparedStatement s = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "update chucvu set tenchucvu = ? , luongcoban = ?" + " where machucvu = ? ";
            s = conn.prepareCall(sql);

            s.setString(1, chucvu.getTenchucvu());
            s.setInt(2, chucvu.getLuongcoban());
            s.setString(3, chucvu.getMachucvu());

            s.execute();
            System.out.println("ĐÃ SỬA THÔNG TIN CHỨC VỤ!");
        } catch (SQLException ex) {
            System.out.println("Sửa Thất Bại! Lỗi: " + ex.getMessage());
        }

    }

    public static void search_info() {
        System.out.println("NHẬP TÊN NHÂN VIÊN CẦN TÌM: ");
        String hoten = scan.nextLine();
        PreparedStatement statement = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "select *from nhanvien where hoten like ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + hoten + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NhanVien std = new NhanVien(
                        resultSet.getString("manhanvien"),
                        resultSet.getString("hoten"),
                        resultSet.getString("gioitinh"),
                        resultSet.getString("diachi"),
                        resultSet.getString("SDT"),
                        resultSet.getString("email"),
                        resultSet.getString("machucvu"));
                std.display();
            }
        } catch (SQLException ex) {
            System.out.println("Tìm Kiếm Thất Bại! Lỗi: " + ex.getMessage());
        }
    }

    public static void searchGT() {
        System.out.println("NHẬP GIỚI TÍNH NHÂN VIÊN: ");
        String gioitinh = scan.nextLine();
        PreparedStatement statement = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "select *from nhanvien where gioitinh like ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + gioitinh + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NhanVien std = new NhanVien(
                        resultSet.getString("manhanvien"),
                        resultSet.getString("hoten"),
                        resultSet.getString("gioitinh"),
                        resultSet.getString("diachi"),
                        resultSet.getString("SDT"),
                        resultSet.getString("email"),
                        resultSet.getString("machucvu"));
                std.display();
            }
        } catch (SQLException ex) {
            System.out.println("Tìm Kiếm Thất Bại! Lỗi: " + ex.getMessage());
        }
    }

    public static void search_tonggio() {
        System.out.println("NHẬP MÃ NHÂN VIÊN CẦN XEM TỔNG GIỜ LÀM (NVxx): ");
        String manhanvien = scan.nextLine();
        PreparedStatement statement = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "select *from tinhluong where manhanvien like ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + manhanvien + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TinhLuong std = new TinhLuong(
                        resultSet.getString("manhanvien"),
                        resultSet.getString("machucvu"),
                        resultSet.getInt("tonggio")
                );
                std.display();
            }
        } catch (SQLException ex) {
            System.out.println("Tìm Kiếm Thất Bại! Lỗi: " + ex.getMessage());
        }
    }

    public static void searchCV() {
        System.out.println("NHẬP TÊN CHỨC VỤ CẦN TÌM: ");
        String tenchucvu = scan.nextLine();
        PreparedStatement statement = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qlnhanvien?user=root");
            String sql = "select *from chucvu where tenchucvu like ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + tenchucvu + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ChucVu std = new ChucVu(
                        resultSet.getString("machucvu"),
                        resultSet.getString("tenchucvu"),
                        resultSet.getInt("luongcoban")
                );
                std.display();
            }
        } catch (SQLException ex) {
            System.out.println("Tìm Kiếm Thất Bại! Lỗi: " + ex.getMessage());
        }
    }

}

