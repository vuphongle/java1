package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
//	public boolean createKH(kh) {
//		try {
//			ConnectDB.getInstance();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("insert into KhachHang values (?, ?, ?, ?, ?)");
//			stmt.setString(1, kh.getMaKH());
//			stmt.setString(2, kh.getTenKH());
//			stmt.setString(3, kh.getGioiTinh());
//			stmt.setString(4, kh.getDiaChi());
//			stmt.setString(5, kh.getSdt());
//
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return n > 0;
//	}
	
	public void ABC() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from AB";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			
		}
	}
}
