package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LopHoc;

public class LopHocDAO {
	public ArrayList<LopHoc> getAllLopHoc() {
		ArrayList<LopHoc> dsLopHoc = new ArrayList<LopHoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LopHoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsLopHoc.add(new LopHoc(rs.getString("maLop"), rs.getString("tenLop")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLopHoc;
	}

	public int[] siso() {
		ArrayList<Integer> siso = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select COUNT(p.masv) as siSo from LopHoc o left join SinhVien p on o.maLop = p.maLop group by o.maLop";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				siso.add(rs.getInt("siSo"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return siso.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public String siSo1Lop(String ma) {
	    int ss = 0;
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    try {
	        String sql = "SELECT COUNT(*) AS siSo FROM SinhVien WHERE maLop = '" + ma + "'";
	        Statement statement = con.createStatement();
	        ResultSet rs = statement.executeQuery(sql);
	        while (rs.next()) {
	            ss = rs.getInt("siSo");
	        }
	    } catch (Exception e) {
	        // TODO: handle exception
	    }
	    return String.valueOf(ss);
	}

}
