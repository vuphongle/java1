package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LopHoc;
import entity.SinhVien;

public class SinhVienDAO {
	public ArrayList<SinhVien> getAllSinhVien(){
		ArrayList<SinhVien> dsLopHoc = new ArrayList<SinhVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from SinhVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsLopHoc.add(new SinhVien(
						rs.getString("masv"),
						rs.getString("ho"),
						rs.getString("ten"),
						rs.getString("phai"),
						rs.getString("email"),
						rs.getString("diaChi"),
						rs.getString("maLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLopHoc;
	}
}
