package Mobile_shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mobile_DAO {
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    static List<Mobile_DTO> data = new ArrayList<>();

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8?user=root&password=adarsh@221");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addMobile(Mobile_DTO dto1) {
        int count = 0;
        try {
            ps = con.prepareStatement("insert into mobile_shop values(?,?,?,?,?,?)");
            ps.setInt(1, dto1.getModelNo());
            ps.setString(2, dto1.getModelName());
            ps.setString(3, dto1.getCompany());
            ps.setString(4, dto1.getRam());
            ps.setString(5, dto1.getCameraPixel());
            ps.setDouble(6, dto1.getPrice());
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Mobile_DTO> searchByCompany(String cName) {
        try {
            ps = con.prepareStatement("select * from mobile_shop where company = '" + cName + "'");
            repeat();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public List<Mobile_DTO> searchByPrice(double price1, double price2) {
        try {
            ps = con.prepareStatement("select * from mobile_shop where price between " + price1 + " and " + price2 + " ");
            repeat();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<Mobile_DTO> searchByRam(String ram) {
        try {
            ps = con.prepareStatement("select * from mobile_shop where ram = '" + ram + "'");
            repeat();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<Mobile_DTO> searchByCamera(String pixel1, String pixel2) {
        try {
            ps = con.prepareStatement("select * from mobile_shop where pixel between '" + pixel1 + "' and '" + pixel2 + "' ");
            repeat();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public int deleteMobile(int modelNo) {
        int count = 0;
        try {
            ps = con.prepareStatement("delete from mobile_shop where modelno = " + modelNo + " ");
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void repeat() {
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getDouble(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
