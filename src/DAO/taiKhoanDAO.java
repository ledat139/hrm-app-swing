package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.databaseConnection;
import model.nhanVien;
import model.phongBan;
import model.taiKhoan;

public class taiKhoanDAO implements DAOinterface<taiKhoan> {
	public static taiKhoanDAO getInstance() {
		return new taiKhoanDAO();
	}

	@Override
	public taiKhoan selectByID(taiKhoan t) {
		// TODO Auto-generated method stub
		taiKhoan tk = null;

		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM TAIKHOAN TK INNER JOIN NHANVIEN NV ON  TK.MANV = NV.MANV INNER JOIN PHONGBAN PB ON PB.MAPB = NV.MAPB WHERE TENTK = ? AND MATKHAU = ?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, t.getTenTK());
			st.setString(2, t.getMatKhau());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maTK = rs.getInt("MATK");
				int maNV = rs.getInt("MANV");
				String hoTen = rs.getString("HOTEN");
				String gioiTinh = rs.getString("GIOITINH");
				Date ngSinh = rs.getDate("NGSINH");
				String soDienThoai = rs.getString("SDT");
				String email = rs.getString("EMAIL");
				String diaChi = rs.getString("DIACHI");
				String cccd = rs.getString("CCCD");
				String capBac = rs.getString("CAPBAC");
				phongBan phongBan = new phongBan(rs.getInt("MAPB"), rs.getString("TENPB"), rs.getDate("NGTHANHLAP"),
						rs.getInt("MATRUONGPHONG"), rs.getDate("NGAYNHANCHUC"));
				nhanVien nvReal = new nhanVien(maNV, hoTen, gioiTinh, ngSinh, soDienThoai, email, diaChi, cccd, capBac,
						phongBan);

				String tenTK = rs.getString("TENTK");
				String matKhau = rs.getString("MATKHAU");
				String loaiTK = rs.getString("LOAITAIKHOAN");
				tk = new taiKhoan(maTK, nvReal, tenTK, matKhau, loaiTK);
			}

			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tk;
	}

	@Override
	public ArrayList<taiKhoan> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertT(taiKhoan t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateT(taiKhoan t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteT(taiKhoan t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int seq_num() {
		// TODO Auto-generated method stub
		return 0;
	}

}
